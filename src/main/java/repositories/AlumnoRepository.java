
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Actor;
import domain.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

	@Query("select a from Alumno a where a.id = ?1")
	Collection<Alumno> findById(int idAlumno);

	@Query("select a from Alumno a where a.userAccount.id = ?1")
	Alumno findByAccountId(int idAccountAlumno);

	@Query("select s from Alumno a join a.suscritos s where a.id = ?1")
	Collection<Actor> findSuscriptorByAlumno(int idAlumno);

	@Query("select AVG((a.comentarios.size)) FROM Alumno a")
	double findAvgComentariosPorAlumno();

	@Query("select AVG((a.suscritos.size)) FROM Alumno a")
	double findAvgSuscripcionesPorAlumno();
}
