
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
		return null;
	}

	public Alumno findOne(final int alumnoId) {
		return null;
	}
	public Alumno save(final Alumno alumno) {
		return null;
	}
	public void delete(final Alumno alumno) {
	}
}
