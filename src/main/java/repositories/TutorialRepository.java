
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Tutorial;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {

	@Query("select t from Tutorial t where t.id = ?1")
	Collection<Tutorial> findById(int Tutorial);

	@Query("select t from Academia a join a.tutoriales t where a.id = ?1")
	Collection<Tutorial> findAllByAcademia(int idAcademia);

	@Query("select t from Academia a join a.tutoriales t where a.id = ?1 and t.id = ?2")
	Tutorial findOneByAcademia(int idAcademia, int idTutorial);

	@Query("select MIN(t.contador) FROM Tutorial t")
	int findMinVecesMostrado();

	@Query("select AVG(t.contador) FROM Tutorial t")
	double findAvgVecesMostrado();

	@Query("select MAX(t.contador) FROM Tutorial t")
	int findMaxVecesMostrado();

	@Query("select t FROM Tutorial t ORDER BY t.contador DESC")
	Collection<Tutorial> findAllOrderByVecesMostradoDesc();
}
