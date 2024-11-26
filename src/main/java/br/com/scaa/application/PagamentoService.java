package br.com.scaa.application;

import br.com.scaa.domain.AssinaturaModel;
import br.com.scaa.domain.PagamentoModel;
import br.com.scaa.domain.repository.IPagamentoRepository;
import br.com.scaa.infraestructure.persistence.entities.Pagamento;
import br.com.scaa.infraestructure.persistence.repository.IPagamentoJPARepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PagamentoService {

    private final IPagamentoJPARepository pagamentoRepository;
    private final AssinaturaService assinaturaService;
    private final RabbitTemplate rabbitTemplate;

    public PagamentoService(IPagamentoJPARepository pagamentoRepository,
                            AssinaturaService assinaturaService,
                            RabbitTemplate rabbitTemplate) {
        this.pagamentoRepository = pagamentoRepository;
        this.assinaturaService = assinaturaService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Transactional // Garante atomicidade
    public LocalDateTime save(PagamentoModel pagamento) throws Exception {
        // Validações do pagamento
        pagamento.validate();

        // Busca a assinatura associada
        AssinaturaModel assinaturaModel = assinaturaService.findByCodigo(pagamento.getAssinaturaCodigo());
        if (assinaturaModel == null) {
            throw new Exception("Assinatura não encontrada");
        }

        // Verifica se o valor pago é correto
        if (assinaturaModel.getAplicativo().getCustoMensal() != pagamento.getValorPago()) {
            throw new Exception("Valor do pagamento não corresponde ao valor da assinatura");
        }

        // Associa assinatura ao pagamento e salva no repositório
        pagamento.setAssinatura(assinaturaModel);
        Pagamento entidadePagamento = Pagamento.fromPagamentoModel(pagamento);
        Pagamento pagamentoSalvo = pagamentoRepository.save(entidadePagamento);

        // Renova a assinatura associada
        assinaturaService.renovaAssinatura(pagamentoSalvo.getAssinatura().getCodigo());

        // Publica evento no RabbitMQ
        rabbitTemplate.convertAndSend("assinatura-exchange", "pagamento-key", pagamentoSalvo);

        // Retorna a nova data de fim da vigência
        return assinaturaModel.getFimVigencia();
    }
}
