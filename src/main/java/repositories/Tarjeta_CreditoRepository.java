
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Tarjeta_Credito;

@Repository
public interface Tarjeta_CreditoRepository extends JpaRepository<Tarjeta_Credito, Integer> {

	@Query("select t from Tarjeta_Credito t where t.id = ?1")
	Collection<Tarjeta_Credito> findById(int Tarjeta_Credito);

	@Query("select t from Alumno a join a.tarjetaCredito t where a.id = ?1")
	Tarjeta_Credito findByTarjetasPorAlumno(int idAlumno);
}
