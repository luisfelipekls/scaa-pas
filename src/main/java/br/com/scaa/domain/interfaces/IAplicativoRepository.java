package br.com.scaa.domain.interfaces;
import br.com.scaa.domain.Aplicativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAplicativoRepository extends JpaRepository<Aplicativo, Long> {
}
