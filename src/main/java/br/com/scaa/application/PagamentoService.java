package br.com.scaa.application;

import br.com.scaa.domain.AssinaturaModel;
import br.com.scaa.domain.PagamentoModel;
import br.com.scaa.domain.repository.IPagamentoRepository;
import br.com.scaa.infraestructure.persistence.entities.Assinatura;
import br.com.scaa.infraestructure.persistence.entities.Pagamento;
import br.com.scaa.infraestructure.persistence.repository.IPagamentoJPARepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PagamentoService {
    private IPagamentoJPARepository pagamentoRepository;
    private AssinaturaService assinaturaService;

    public PagamentoService(IPagamentoJPARepository pagamentoRepository, AssinaturaService assinaturaService) {
        this.pagamentoRepository = pagamentoRepository;
        this.assinaturaService = assinaturaService;
    }

    public LocalDateTime save(PagamentoModel pagamento) {
        pagamento.validate();
        AssinaturaModel assinaturaModel = assinaturaService.findByCodigo(pagamento.getAssinaturaCodigo());
        if(assinaturaModel == null){
            throw new RuntimeException("Assinatura não encontrada");
        }
        if(assinaturaModel.getAplicativo().getCustoMensal() != pagamento.getValorPago()){
            throw new RuntimeException("Valor do pagamento não corresponde ao valor da assinatura");
        }
        pagamento.setAssinatura(assinaturaModel);
        Pagamento pag = Pagamento.fromPagamentoModel(pagamento);
        Pagamento pagamentoRealizado = pagamentoRepository.save(pag);
        assinaturaService.renovaAssinatura(pagamentoRealizado.getAssinatura().getCodigo());
        return assinaturaModel.getFimVigencia();
    }
}
