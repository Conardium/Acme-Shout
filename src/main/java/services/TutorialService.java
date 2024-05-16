
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Assert;
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
	public TutorialService() {
		super();
	}
	public Tutorial create() {
		Tutorial result;

		result = new Tutorial();

		return result;
	}
	public Collection<Tutorial> findAll() {
		Collection<Tutorial> result;

		Assert.assertNotNull(this.tutorialRepository);
		result = this.tutorialRepository.findAll();
		Assert.assertNotNull(result);

		return result;
	}
	public Tutorial findOne(final int tutorialId) {
		Tutorial result;

		result = this.tutorialRepository.findOne(tutorialId);

		return result;
	}
	public Tutorial save(final Tutorial tutorial) {
		Assert.assertNotNull(tutorial);

		Tutorial result;

		result = this.tutorialRepository.save(tutorial);

		return result;
	}
	public void delete(final Tutorial tutorial) {
		Assert.assertNotNull(tutorial);
		Assert.assertEquals(tutorial.getId(), 0);

		this.tutorialRepository.delete(tutorial);
	}

}
