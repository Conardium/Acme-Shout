
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Curso;
import repositories.CursoRepository;

@Service
@Transactional
public class CursoService {

	// Managed repository -------------------------------
	@Autowired
	private CursoRepository cursoRepository;

	// Supporting services ------------------------------
	//


	// Simple CRUD methods ------------------------------
	public Curso create() {
		return null;
	}

	public Collection<Curso> findAll() {
		return null;
	}

	public Curso findOne(final int cursoId) {
		return null;
	}
	public Curso save(final Curso curso) {
		return null;
	}
	public void delete(final Curso curso) {
	}
}
