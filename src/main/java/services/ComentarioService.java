
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Comentario;
import repositories.ComentarioRepository;

@Service
@Transactional
public class ComentarioService {

	// Managed repository -------------------------------
	@Autowired
	private ComentarioRepository comentarioRepository;

	// Supporting services ------------------------------


	// Simple CRUD methods ------------------------------
	public ComentarioService() {
		super();
	}

	public Comentario create() {
		Comentario result;

		result = new Comentario();

		return result;
	}

	public Collection<Comentario> findAll() {
		Collection<Comentario> result;

		Assert.assertNotNull(this.comentarioRepository);
		result = this.comentarioRepository.findAll();
		Assert.assertNotNull(result);

		return result;
	}

	public Comentario findOne(final int comentarioId) {
		Comentario result;

		result = this.comentarioRepository.findOne(comentarioId);

		return result;
	}

	public Comentario save(final Comentario comentario) {
		Assert.assertNotNull(comentario);

		Comentario result;

		result = this.comentarioRepository.save(comentario);

		return result;
	}

	public void delete(final Comentario comentario) {
		Assert.assertNotNull(comentario);
		Assert.assertNotEquals(comentario.getId(), 0);

		this.comentarioRepository.delete(comentario);
	}

	// Not Simple CRUD methods ------------------------------
	public Collection<Comentario> findAllComentariosByAlumno(final int idAlumno) {
		Collection<Comentario> result;

		result = this.comentarioRepository.findAllComentariosByAlumno(idAlumno);

		return result;
	}

	public Collection<Comentario> findAllComentariosByAcademia(final int idAcademia) {
		Collection<Comentario> result;

		result = this.comentarioRepository.findAllComentariosByAcademia(idAcademia);

		return result;
	}

	public Collection<Comentario> findAllOrderByfechaPublicacionDesc() {
		Collection<Comentario> result;

		result = this.comentarioRepository.findAllOrderByfechaPublicacionDesc();

		return result;
	}
}
