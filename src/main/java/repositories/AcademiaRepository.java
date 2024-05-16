
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Academia;

@Repository
public interface AcademiaRepository extends JpaRepository<Academia, Integer> {

	@Query("select a from Academia a where a.id = ?1")
	Collection<Academia> findById(int idAcademia);

	@Query("select a from Academia a join a.cursos c where c.id = ?1")
	Academia findByAcademiaporCurso(int idCurso);

	@Query("select a from Academia a join a.solicitudes s where s.id = ?1")
	Academia findByAcademiaporSolicitud(int idSolicitud);

	@Query("select a from Academia a join a.tutoriales t where t.id = ?1")
	Academia findByAcademiaporTutorial(int idTutorial);

	@Query("select MIN(size(a.cursos)) FROM Academia a")
	int findMinCursosByAcademia();

	@Query("select AVG(size(a.cursos)) FROM Academia a")
	double findAvgCursosByAcademia();

	@Query("select STDDEV(size(a.cursos)) FROM Academia a")
	double findStdDevCursosByAcademia();

	@Query("select MAX(size(a.cursos)) FROM Academia a")
	int findMaxCursosByAcademia();

	@Query("select MIN(size(a.tutoriales)) FROM Academia a")
	int findMinTutorialesByAcademia();

	@Query("select AVG(size(a.tutoriales)) FROM Academia a")
	double findAvgTutorialesByAcademia();

	@Query("select MAX(size(a.tutoriales)) FROM Academia a")
	int findMaxTutorialesByAcademia();

	@Query("select s from Academia a join a.suscritos s where a.id = ?1")
	Collection<Academia> findSuscritporByAcademia(int idAcademia);

	@Query("select AVG(size(a.comentarios)) FROM Academia a")
	double findAvgComentariosPorAcademia();

	@Query("select AVG(size(a.suscripciones)) FROM Academia a")
	double findAvgSuscripcionesPorAcademia();

}
