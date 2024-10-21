package br.com.scaa.infraestructure.persistence.repository;

import br.com.scaa.infraestructure.persistence.entities.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAssinaturaJPARepository extends JpaRepository<Assinatura, Long> {
}
