
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Academia;
import domain.Actor;

@Repository
public interface AcademiaRepository extends JpaRepository<Academia, Integer> {

	@Query("select a from Academia a where a.id = ?1")
	Collection<Academia> findById(int idAcademia);

	@Query("select a from Academia a join a.cursos c where c.id = ?1")
	Academia findByAcademiaporCurso(int idCurso);

	@Query("select a from Academia a join a.userAccount u where u.id = ?1")
	Academia findByAccountId(int idAccountAcademia);

	@Query("select a from Academia a join a.solicitudes s where s.id = ?1")
	Academia findByAcademiaporSolicitud(int idSolicitud);

	@Query("select a from Academia a join a.tutoriales t where t.id = ?1")
	Academia findByAcademiaporTutorial(int idTutorial);

	@Query("select s from Academia a join a.suscritos s where a.id = ?1")
	Collection<Actor> findSuscriptorByAcademia(int idAcademia);

	@Query("select MIN((a.cursos.size)) FROM Academia a")
	int findMinCursosByAcademia();

	@Query("select AVG((a.cursos.size)) FROM Academia a")
	double findAvgCursosByAcademia();

	@Query("select STDDEV((a.cursos.size)) FROM Academia a")
	double findStdDevCursosByAcademia();

	@Query("select MAX((a.cursos.size)) FROM Academia a")
	int findMaxCursosByAcademia();

	@Query("select MIN((a.tutoriales.size)) FROM Academia a")
	int findMinTutorialesByAcademia();

	@Query("select AVG((a.tutoriales.size)) FROM Academia a")
	double findAvgTutorialesByAcademia();

	@Query("select MAX((a.tutoriales.size)) FROM Academia a")
	int findMaxTutorialesByAcademia();

	@Query("select AVG((a.comentarios.size)) FROM Academia a")
	double findAvgComentariosPorAcademia();

	@Query("select AVG((a.suscritos.size)) FROM Academia a")
	double findAvgSuscriptoresPorAcademia();

}
