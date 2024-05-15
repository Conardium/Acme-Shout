
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
	private CursoRepository	cursoRepository;

	// Supporting services ------------------------------
	//
	@Autowired
	private AcademiaService	academiaService;


	// Simple CRUD methods ------------------------------
	public Curso create() {
		return null;
	}

	public Collection<Curso> findAll() {
		return this.cursoRepository.findAll();
	}

	public Curso findOne(final int cursoId) {
		return this.cursoRepository.findOne(cursoId);
	}
	public Curso save(final Curso curso) {
		return this.cursoRepository.save(curso);
	}
	public void delete(final Curso curso) {
		this.cursoRepository.delete(curso);
	}

	// No Simple CRUD methods ------------------------------

	public Collection<Curso> findCursosporAcademia(final int academiaId) {

		return this.academiaService.findOne(academiaId).getCursos();
	}

	public Collection<Curso> findCursosporEstilo(final int estiloId) {

		return this.cursoRepository.findByEstilo(estiloId);
	}
}
