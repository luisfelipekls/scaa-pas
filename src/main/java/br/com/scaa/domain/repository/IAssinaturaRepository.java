package br.com.scaa.domain.repository;

import br.com.scaa.domain.AssinaturaModel;

import java.util.Collection;
import java.util.List;

public interface IAssinaturaRepository {
    AssinaturaModel save(AssinaturaModel assinatura);
    AssinaturaModel findByCodigo(Long codigo);
    List<AssinaturaModel> findByCodigoCliente(Long codigoCliente);
    List<AssinaturaModel> findByCodigoAplicativo(Long codigoAssinatura);
}
