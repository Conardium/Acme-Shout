
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Academia;
import repositories.AcademiaRepository;

@Service
@Transactional
public class AcademiaService {

	// Managed repository -------------------------------
	@Autowired
	private AcademiaRepository	academiaRepository;

	// Supporting services ------------------------------
	@Autowired
	private CursoService		cursoService;


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
		this.cursoService.findOne(cursoId);

		return this.academiaRepository.findOne(cursoId);
	}

}
