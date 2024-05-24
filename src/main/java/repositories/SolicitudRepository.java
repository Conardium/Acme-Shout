
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Solicitud;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {

	@Query("select s from Solicitud s where s.id = ?1")
	Collection<Solicitud> findById(int idSolicitud);

	@Query("select s from Academia a join a.solicitudes s where a.id = ?1")
	Collection<Solicitud> findAllSolicitudesByAcademia(int idAcademia);
}
