
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

	@Query("select c from Alumno a join a.comentarios c where a.id = ?1")
	Collection<Comentario> findAllComentariosByAlumno(int idAlumno);

	@Query("select c from Academia a join a.comentarios c where a.id = ?1")
	Collection<Comentario> findAllComentariosByAcademia(int idAcademia);

	@Query("select c from Comentario c order by c.fechaPublicacion desc")
	Collection<Comentario> findAllOrderByfechaPublicacionDesc();

}
