
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Actor;
import domain.Alumno;
import repositories.AlumnoRepository;

@Service
@Transactional
public class AlumnoService {

	// Managed repository -------------------------------
	@Autowired
	private AlumnoRepository alumnoRepository;

	// Supporting services ------------------------------


	// Simple CRUD methods ------------------------------
	public AlumnoService() {
		super();
	}

	public Alumno create() {
		Alumno result;

		result = new Alumno();

		return result;
	}

	public Collection<Alumno> findAll() {
		Collection<Alumno> result;

		Assert.assertNotNull(this.alumnoRepository);
		result = this.alumnoRepository.findAll();
		Assert.assertNotNull(result);

		return result;
	}

	public Alumno findOne(final int alumnoId) {
		Alumno result;

		result = this.alumnoRepository.findOne(alumnoId);

		return result;
	}

	public Alumno save(final Alumno alumno) {
		Assert.assertNotNull(alumno);

		Alumno result;

		result = this.alumnoRepository.save(alumno);

		return result;
	}

	public void delete(final Alumno alumno) {
		Assert.assertNotNull(alumno);
		Assert.assertEquals(alumno.getId(), 0);

		this.alumnoRepository.delete(alumno);
	}

	// Not Simple CRUD methods ------------------------------

	public Alumno findByAccountId(final int alumnoId) {
		Alumno result;

		result = this.alumnoRepository.findByAccountId(alumnoId);

		return result;
	}

	public Collection<Actor> findSuscritporByAlumno(final int alumnoId) {
		Collection<Actor> result;

		result = this.alumnoRepository.findSuscriptorByAlumno(alumnoId);

		return result;
	}

	public double getAvgComentariosPorAlumno() {
		double result = 0;

		result = this.alumnoRepository.findAvgComentariosPorAlumno();

		return result;
	}

	public double getAvgSuscripcionesPorAlumno() {
		double result = 0;

		result = this.alumnoRepository.findAvgSuscripcionesPorAlumno();

		return result;
	}
}
