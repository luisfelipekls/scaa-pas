package br.com.scaa.domain.repository;
import br.com.scaa.domain.AplicativoModel;


import java.util.List;

public interface IAplicativoRepository {
    List<AplicativoModel> findAll();
    AplicativoModel findById(Long id);
    AplicativoModel save(AplicativoModel aplicativo);
    AplicativoModel update(AplicativoModel aplicativo);
    void delete(AplicativoModel aplicativo);
}
