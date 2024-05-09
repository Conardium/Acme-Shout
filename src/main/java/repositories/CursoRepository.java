
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import domain.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

	@Query("select c from Curso c where c.id = ?1")
	Collection<Curso> findById(int idCurso);
}
