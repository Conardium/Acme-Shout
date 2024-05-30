
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

	@Query("select a from Administrador a where a.id = ?1")
	Collection<Administrador> findById(int idAdministrador);

	@Query("select a from Administrador a where a.userAccount.id = ?1")
	Administrador findByAccountId(int idAccountAdministrador);
}
