
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.Academia;

public interface AcademiaRepository extends JpaRepository<Academia, Integer> {

	@Query("select a from Academia a where a.id = ?1")
	Collection<Academia> findById(int idAcademia);

	@Query("select a from Academia a inner join Curso c where c.id = ?1")
	Academia findAcademiaporCurso(int idCurso);
}
