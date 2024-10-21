package br.com.scaa.infraestructure.persistence.repository;

import br.com.scaa.infraestructure.persistence.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPagamentoJPARepository extends JpaRepository<Pagamento, Long> {
}
