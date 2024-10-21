package br.com.scaa.infraestructure.persistence.repository;
import br.com.scaa.infraestructure.persistence.entities.Aplicativo;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAplicativoJPARepository extends ListCrudRepository<Aplicativo, Long> {
}
