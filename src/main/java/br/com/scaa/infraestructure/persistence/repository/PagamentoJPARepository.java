package br.com.scaa.infraestructure.persistence.repository;

import br.com.scaa.domain.PagamentoModel;
import br.com.scaa.domain.repository.IPagamentoRepository;
import br.com.scaa.infraestructure.persistence.entities.Pagamento;

public class PagamentoJPARepository implements IPagamentoRepository {
    private IPagamentoJPARepository pagamentoRepository;

    @Override
    public PagamentoModel save(PagamentoModel pagamento) {
        Pagamento pag = Pagamento.fromPagamentoModel(pagamento);
        Pagamento pagamentoRegistrado = pagamentoRepository.save(pag);
        return Pagamento.toPagamentoModel(pagamentoRegistrado);
    }
}
