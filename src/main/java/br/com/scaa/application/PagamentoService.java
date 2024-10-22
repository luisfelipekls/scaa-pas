package br.com.scaa.application;

import br.com.scaa.domain.PagamentoModel;
import br.com.scaa.domain.repository.IPagamentoRepository;
import br.com.scaa.infraestructure.persistence.entities.Pagamento;
import br.com.scaa.infraestructure.persistence.repository.IPagamentoJPARepository;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {
    private IPagamentoJPARepository pagamentoRepository;

    public PagamentoService(IPagamentoJPARepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public PagamentoModel save(PagamentoModel pagamento) {
        pagamento.validate();
        return Pagamento.toPagamentoModel(
                pagamentoRepository.save(Pagamento.fromPagamentoModel(pagamento))
        );
    }
}
