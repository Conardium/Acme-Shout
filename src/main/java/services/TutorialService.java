
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Tutorial;
import repositories.TutorialRepository;

@Service
@Transactional
public class TutorialService {

	// Managed repository -------------------------------

	@Autowired
	private TutorialRepository tutorialRepository;

	// Supporting services ------------------------------


	// Simple CRUD methods ------------------------------
	public Tutorial create() {
		return null;
	}
	public Collection<Tutorial> findAll() {
		return null;
	}
	public Tutorial findOne(final int tutorialId) {
		return null;
	}
	public Tutorial save(final Tutorial tutorial) {
		return null;
	}
	public void delete(final Tutorial tutorial) {
		;
	}

}
