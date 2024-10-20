package br.com.scaa.domain.interfaces;

import br.com.scaa.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPagamentoRepository extends JpaRepository<Pagamento, Long> {
}
