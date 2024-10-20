package br.com.scaa.domain.interfaces;

import br.com.scaa.domain.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IAssinaturaRepository extends JpaRepository<Assinatura, Long> {
}
