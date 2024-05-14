
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

	@Query("select a from Administrador a where a.id = ?1")
	Collection<Administrador> findById(int idAdministrador);
}
