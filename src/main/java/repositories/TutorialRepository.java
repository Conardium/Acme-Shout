
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import domain.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {

	@Query("select t from Tutorial t where t.id = ?1")
	Collection<Tutorial> findById(int Tutorial);
}
