
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import domain.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

	@Query("select c from Comentario c where c.id = ?1")
	Collection<Comentario> findById(int idComentario);
}
