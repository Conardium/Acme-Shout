
package services;

import java.util.Collection;

import javax.transaction.Transactional;

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
	public Comentario create() {
		return null;
	}

	public Collection<Comentario> findAll() {
		return null;
	}

	public Comentario findOne(final int comentarioId) {
		return null;
	}
	public Comentario save(final Comentario comentario) {
		return null;
	}
	public void delete(final Comentario comentario) {
	}
}
