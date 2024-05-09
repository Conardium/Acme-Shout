
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import domain.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {

	@Query("select s from Solicitud s where s.id = ?1")
	Collection<Solicitud> findById(int idSolicitud);
}
