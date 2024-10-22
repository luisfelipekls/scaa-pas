package br.com.scaa.infraestructure.persistence.repository;

import br.com.scaa.infraestructure.persistence.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClienteJPARepository extends JpaRepository<Cliente, Long> {
    Cliente findByCodigo(Long codigo);
}
