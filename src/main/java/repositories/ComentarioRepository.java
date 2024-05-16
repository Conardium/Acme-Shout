
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

	@Query("select c from Comentario c where c.id = ?1")
	Collection<Comentario> findById(int idComentario);

	@Query("select c.* from Comentario c inner join Alumno a ON c.actor_id = a.id where a.id = ?1")
	Collection<Comentario> findByIdAlumno(int idAlumno);
}
