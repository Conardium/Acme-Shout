
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Curso;
import domain.Estilo;
import repositories.CursoRepository;

@Service
@Transactional
public class CursoService {

	// Managed repository -------------------------------
	@Autowired
	private CursoRepository cursoRepository;

	// Supporting services ------------------------------


	// Simple CRUD methods ------------------------------
	public CursoService() {
		super();
	}

	public Curso create() {
		Curso result;

		result = new Curso();

		return result;
	}

	public Collection<Curso> findAll() {
		Collection<Curso> result;

		Assert.assertNotNull(this.cursoRepository);
		result = this.cursoRepository.findAll();
		Assert.assertNotNull(result);

		return result;
	}

	public Curso findOne(final int cursoId) {
		Curso result;

		result = this.cursoRepository.findOne(cursoId);

		return result;
	}
	public Curso save(final Curso curso) {
		Assert.assertNotNull(curso);

		Curso result;

		result = this.cursoRepository.save(curso);

		return result;
	}
	public void delete(final Curso curso) {
		Assert.assertNotNull(curso);
		Assert.assertEquals(curso.getId(), 0);

		this.cursoRepository.delete(curso);
	}

	// No Simple CRUD methods ------------------------------

	public Collection<Curso> findCursosporAcademia(final int academiaId) {
		Collection<Curso> result;

		result = this.cursoRepository.findByCursosporAcademia(academiaId);

		return result;
	}

	public Collection<Curso> findCursosporEstilo(final int estiloId) {
		Collection<Curso> result;

		result = this.cursoRepository.findByEstilo(estiloId);

		return result;
	}

	public boolean existeCursoConEstilo(final Estilo estilo) {
		boolean result;
		Collection<Curso> cursos;

		cursos = this.cursoRepository.findByEstilo(estilo.getId());
		result = cursos.isEmpty();

		return result;
	}

	//----- Busquedas de Min, Max, Avg y Std de Solicitudes ----
	//--> MIN
	public int findMinSolicitudesByCurso() {
		int result = 0;

		result = this.cursoRepository.findMinSolicitudesByCurso();

		return result;
	}

	//--> AVG
	public double findAvgSolicitudesByCurso() {
		double result = 0f;

		result = this.cursoRepository.findAvgSolicitudesByCurso();

		return result;
	}

	//--> STD
	public double findStdDevSolicitudesByCurso() {
		double result = 0f;

		result = this.cursoRepository.findStdDevSolicitudesByCurso();

		return result;
	}

	//--> MAX
	public int findMaxSolicitudesByCurso() {
		int result = 0;

		result = this.cursoRepository.findMaxSolicitudesByCurso();

		return result;
	}
	//-------------------------------------------------------------------

	public Collection<Curso> findCursosByFiltro(final String filtro) {
		Collection<Curso> result;

		result = this.findCursosByFiltro(filtro);

		return result;
	}
}
