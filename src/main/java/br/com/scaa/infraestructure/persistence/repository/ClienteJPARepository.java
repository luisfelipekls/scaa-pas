package br.com.scaa.infraestructure.persistence.repository;

import br.com.scaa.domain.ClienteModel;
import br.com.scaa.domain.repository.IClienteRepository;
import br.com.scaa.infraestructure.persistence.entities.Cliente;

import java.util.List;

public class ClienteJPARepository implements IClienteRepository {
    private IClienteJPARepository clienteRepository;

    @Override
    public ClienteModel save(ClienteModel cliente) {
        Cliente cli = Cliente.fromClienteModel(cliente);
        Cliente clienteInserido = clienteRepository.save(cli);
        return Cliente.toClienteModel(clienteInserido);
    }

    @Override
    public ClienteModel findByCodigo(Long codigo) {
        Cliente cliente = clienteRepository.findByCodigo(codigo);
        return Cliente.toClienteModel(cliente);
    }

    @Override
    public void delete(Long codigo) {
        clienteRepository.deleteById(codigo);
    }

    @Override
    public ClienteModel update(ClienteModel cliente) {
        Cliente cli = Cliente.fromClienteModel(cliente);
        Cliente clienteAtualizado = clienteRepository.save(cli);
        return Cliente.toClienteModel(clienteAtualizado);
    }

    @Override
    public List<ClienteModel> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(cli -> Cliente.toClienteModel(cli)).toList();
    }
}
