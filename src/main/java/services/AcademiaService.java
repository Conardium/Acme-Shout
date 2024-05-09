
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
	private AcademiaRepository academiaRepository;

	// Supporting services ------------------------------


	// Simple CRUD methods ------------------------------
	public Academia create() {
		return null;
	}

	public Collection<Academia> findAll() {
		return null;
	}

	public Academia findOne(final int academiaId) {
		return null;
	}
	public Academia save(final Academia academia) {
		return null;
	}
	public void delete(final Academia academia) {
	}
}
