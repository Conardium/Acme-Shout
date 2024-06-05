
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

	@Query("select c from Curso c where c.id = ?1")
	Collection<Curso> findById(int idCurso);

	@Query("select c from Curso c where c.estilo.id = ?1")
	Collection<Curso> findByEstilo(int idEstilo);

	@Query("select c from Academia a join a.cursos c where a.id = ?1")
	Collection<Curso> findByCursosporAcademia(int idAcademia);

	@Query("select min((c.solicitudes.size)) from Curso c")
	int findMinSolicitudesByCurso();

	@Query("select avg((c.solicitudes.size)) from Curso c")
	double findAvgSolicitudesByCurso();

	@Query("select stddev((c.solicitudes.size)) from Curso c")
	double findStdDevSolicitudesByCurso();

	@Query("select max((c.solicitudes.size)) from Curso c")
	int findMaxSolicitudesByCurso();

	@Query("select distinct c from Curso c join c.estilo e where c.titulo like '%?1%' OR e.nombre LIKE '%?1%' OR e.descripcion LIKE '%?1%'")
	Collection<Curso> findCursosByFiltro(String filtro);

	@Query("select distinct a.c from Academia a join a.c.estilo e where a.id = ?1 AND (a.c.titulo like '%?2%' OR e.nombre LIKE '%?2%' OR e.descripcion LIKE '%?2%')")
	Collection<Curso> findCursosByAcademyWithFiltro(int idAcademia, String filtro);

	@Query("select distinct c from Curso c join c.estilo e where c.id not in (select s.curso.id from Alumno a join a.solicitudes s where a.id = ?1) AND (c.titulo like '%?2%' OR e.nombre LIKE '%?2%' OR e.descripcion LIKE '%?2%')")
	Collection<Curso> findCursosNotSolicitedByAlumnoWithFiltro(int idAlumno, String filtro);

	@Query("select distinct c from Curso c where c.id not in (select s.curso.id from Alumno a join a.solicitudes s where a.id = ?1)")
	Collection<Curso> findCursosNotSolicitedByAlumno(int idAlumno);
}
