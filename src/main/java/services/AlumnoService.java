
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Alumno create() {
		return null;
	}

	public Collection<Alumno> findAll() {
		return this.alumnoRepository.findAll();
	}

	public Alumno findOne(final int alumnoId) {
		return this.alumnoRepository.findOne(alumnoId);
	}
	public Alumno save(final Alumno alumno) {
		return this.alumnoRepository.save(alumno);
	}
	public void delete(final Alumno alumno) {
		this.alumnoRepository.delete(alumno);
	}
}
