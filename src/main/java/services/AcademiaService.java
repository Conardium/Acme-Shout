
package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Academia;
import domain.Curso;
import repositories.AcademiaRepository;

@Service
@Transactional
public class AcademiaService {

	// Managed repository -------------------------------
	@Autowired
	private AcademiaRepository academiaRepository;

	// Supporting services ------------------------------


	// Simple CRUD methods ------------------------------
	public Academia create() {
		return null;
	}

	public Collection<Academia> findAll() {
		return this.academiaRepository.findAll();
	}

	public Academia findOne(final int academiaId) {
		return this.academiaRepository.findOne(academiaId);
	}
	public Academia save(final Academia academia) {
		return this.academiaRepository.save(academia);
	}
	public void delete(final Academia academia) {
		this.academiaRepository.delete(academia);
	}

	// Not Simple CRUD methods ------------------------------

	public Academia findAcademiaporCurso(final int cursoId) {

		final ArrayList<Academia> academias = new ArrayList<Academia>(this.academiaRepository.findAll());
		final int numAcademias = academias.size();

		for (int i = 0; i < numAcademias; i++) {
			final ArrayList<Curso> cursos = new ArrayList<Curso>(academias.get(i).getCursos());
			final int numCursos = cursos.size();

			for (int j = 0; j < numCursos; j++)
				if (cursos.get(j).getId() == cursoId)
					return academias.get(i);
		}

		return null;
	}

}
