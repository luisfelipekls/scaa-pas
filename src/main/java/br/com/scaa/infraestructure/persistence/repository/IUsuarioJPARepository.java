package br.com.scaa.infraestructure.persistence.repository;
import br.com.scaa.infraestructure.persistence.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioJPARepository extends JpaRepository<Usuario, Long> {
}
