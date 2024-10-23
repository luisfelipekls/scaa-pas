package br.com.scaa.application;

import br.com.scaa.domain.ClienteModel;
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

    public List<ClienteModel> findAll(){ return clienteRepository.findAll().stream().map(
            Cliente::toClienteModel).toList();
    }

    public ClienteModel findByCodigo(Long codigo){ return Cliente.toClienteModel(clienteRepository.findByCodigo(codigo));}

    public ClienteModel save(Cliente cliente){ return Cliente.toClienteModel(clienteRepository.save(cliente));}

    public ClienteModel update(Cliente cliente){ return Cliente.toClienteModel(clienteRepository.save(cliente));}

}
