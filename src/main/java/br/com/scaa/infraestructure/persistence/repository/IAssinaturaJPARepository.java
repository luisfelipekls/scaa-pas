package br.com.scaa.infraestructure.persistence.repository;

import br.com.scaa.infraestructure.persistence.entities.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAssinaturaJPARepository extends JpaRepository<Assinatura, Long> {
    List<Assinatura> findByClienteCodigo(Long codigoCliente);

    List<Assinatura> findByAplicativoCodigo(Long codigoAplicativo);
}
