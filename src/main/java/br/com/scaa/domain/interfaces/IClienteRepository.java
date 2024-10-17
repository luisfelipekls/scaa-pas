package br.com.scaa.domain.interfaces;

import br.com.scaa.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
