
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Academia;
import domain.Actor;
import repositories.AcademiaRepository;

@Service
@Transactional
public class AcademiaService {

	// Managed repository -------------------------------
	@Autowired
	private AcademiaRepository academiaRepository;

	// Supporting services ------------------------------


	// Simple CRUD methods ------------------------------
	public AcademiaService() {
		super();
	}

	public Academia create() {
		Academia result;

		result = new Academia();

		return result;
	}

	public Collection<Academia> findAll() {
		Collection<Academia> result;

		Assert.assertNotNull(this.academiaRepository);
		result = this.academiaRepository.findAll();
		Assert.assertNotNull(result);

		return result;
	}

	public Academia findOne(final int academiaId) {
		Academia result;

		result = this.academiaRepository.findOne(academiaId);

		return result;
	}

	public Academia save(final Academia academia) {
		Assert.assertNotNull(academia);

		Academia result;

		result = this.academiaRepository.save(academia);

		return result;
	}

	public void delete(final Academia academia) {
		Assert.assertNotNull(academia);
		Assert.assertEquals(academia.getId(), 0);

		this.academiaRepository.delete(academia);
	}

	// Not Simple CRUD methods ------------------------------
	public Academia findAcademiaporCurso(final int cursoId) {
		Academia result;

		result = this.academiaRepository.findByAcademiaporCurso(cursoId);

		return result;
	}

	public Collection<Actor> findSuscritporByAcademia(final int academiaId) {
		Collection<Actor> result;

		result = this.academiaRepository.findSuscriptorByAcademia(academiaId);

		return result;
	}

	public int findMinCursosByAcademia() {
		int result = 0;

		result = this.academiaRepository.findMinCursosByAcademia();

		return result;
	}

	public double findAvgCursosByAcademia() {
		double result = 0;

		result = this.academiaRepository.findAvgCursosByAcademia();

		return result;
	}

	public double findStdDevCursosByAcademia() {
		double result = 0;

		result = this.academiaRepository.findStdDevCursosByAcademia();

		return result;
	}

	public int findMaxCursosByAcademia() {

		int result = 0;

		result = this.academiaRepository.findMaxCursosByAcademia();

		return result;
	}
	public int findMinTutorialesByAcademia() {
		int result = 0;

		result = this.academiaRepository.findMinTutorialesByAcademia();

		return result;
	}

	public double findAvgTutorialesByAcademia() {
		double result = 0;

		result = this.academiaRepository.findAvgTutorialesByAcademia();

		return result;
	}

	public int findMaxTutorialesByAcademia() {

		int result = 0;

		result = this.academiaRepository.findMaxTutorialesByAcademia();

		return result;
	}

	public double getAvgComentariosPorAcademia() {
		double result = 0;

		result = this.academiaRepository.findAvgComentariosPorAcademia();

		return result;
	}

	public double getAvgSuscriptoresPorAcademia() {
		double result = 0;

		result = this.academiaRepository.findAvgSuscriptoresPorAcademia();

		return result;
	}
}
