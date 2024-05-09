
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import domain.Tarjeta_Credito;

public interface Tarjeta_CreditoRepository extends JpaRepository<Tarjeta_Credito, Integer> {

	@Query("select t from Tarjeta_Credito t where t.id = ?1")
	Collection<Tarjeta_Credito> findById(int Tarjeta_Credito);
}
