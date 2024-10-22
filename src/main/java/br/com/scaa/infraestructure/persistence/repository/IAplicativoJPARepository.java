package br.com.scaa.infraestructure.persistence.repository;
import br.com.scaa.infraestructure.persistence.entities.Aplicativo;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAplicativoJPARepository extends ListCrudRepository<Aplicativo, Long> {
    Aplicativo findByCodigo(Long codigo);
}
