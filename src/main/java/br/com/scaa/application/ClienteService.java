package br.com.scaa.application;

import br.com.scaa.infraestructure.persistence.entities.Cliente;
import br.com.scaa.infraestructure.persistence.repository.IClienteJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final IClienteJPARepository clienteRepository;

    public ClienteService(IClienteJPARepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll(){ return clienteRepository.findAll();}

    public Cliente findByCodigo(Long codigo){ return clienteRepository.findByCodigo(codigo);}

    public Cliente save(Cliente cliente){ return clienteRepository.save(cliente);}

    public Cliente update(Cliente cliente){ return clienteRepository.save(cliente);}

    public void delete(Cliente cliente){ clienteRepository.delete(cliente);}
}
