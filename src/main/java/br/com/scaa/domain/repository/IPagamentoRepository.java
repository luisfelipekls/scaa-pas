package br.com.scaa.domain.repository;

import br.com.scaa.domain.PagamentoModel;
import br.com.scaa.infraestructure.persistence.entities.Pagamento;

public interface IPagamentoRepository {
    PagamentoModel save(PagamentoModel pagamento);

}
