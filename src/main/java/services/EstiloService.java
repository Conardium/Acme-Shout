
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Estilo;
import repositories.EstiloRepository;

@Service
@Transactional
public class EstiloService {

	// Managed repository -------------------------------

	@Autowired
	private EstiloRepository estiloRepository;

	// Supporting services ------------------------------


	// Simple CRUD methods ------------------------------
	public Estilo create() {
		return null;
	}
	public Collection<Estilo> findAll() {
		Collection<Estilo> result;

		Assert.assertNotNull(this.estiloRepository);
		result = this.estiloRepository.findAll();
		Assert.assertNotNull(result);

		return result;
	}
	public Estilo findOne(final int estiloId) {
		Estilo result;

		result = this.estiloRepository.findOne(estiloId);

		return result;
	}
	public Estilo save(final Estilo estilo) {
		Assert.assertNotNull(estilo);

		Estilo result;

		result = this.estiloRepository.save(estilo);

		return result;
	}
	public void delete(final Estilo estilo) {
		Assert.assertNotNull(estilo);
		Assert.assertEquals(estilo.getId(), 0);

		this.estiloRepository.delete(estilo);
	}

}
