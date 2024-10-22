package br.com.scaa.domain.repository;

import br.com.scaa.domain.ClienteModel;

import java.util.List;

public interface IClienteRepository {
    ClienteModel save(ClienteModel cliente);
    ClienteModel findByCodigo(Long codigo);
    void delete(Long codigo);
    ClienteModel update(ClienteModel cliente);
    List<ClienteModel> findAll();
}
