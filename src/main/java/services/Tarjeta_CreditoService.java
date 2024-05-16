
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Tarjeta_Credito;
import repositories.Tarjeta_CreditoRepository;

@Service
@Transactional
public class Tarjeta_CreditoService {

	// Managed repository -------------------------------

	@Autowired
	private Tarjeta_CreditoRepository tarjeta_CreditoRepository;

	// Supporting services ------------------------------


	// Simple CRUD methods ------------------------------
	public Tarjeta_Credito create() {
		Tarjeta_Credito result;

		result = new Tarjeta_Credito();

		return result;
	}
	public Collection<Tarjeta_Credito> findAll() {
		Collection<Tarjeta_Credito> result;

		Assert.assertNotNull(this.tarjeta_CreditoRepository);
		result = this.tarjeta_CreditoRepository.findAll();
		Assert.assertNotNull(result);

		return result;
	}
	public Tarjeta_Credito findOne(final int tarjeta_CreditoId) {
		Tarjeta_Credito result;

		result = this.tarjeta_CreditoRepository.findOne(tarjeta_CreditoId);

		return result;
	}
	public Tarjeta_Credito save(final Tarjeta_Credito tarjeta_Credito) {
		Assert.assertNotNull(tarjeta_Credito);

		Tarjeta_Credito result;

		result = this.tarjeta_CreditoRepository.save(tarjeta_Credito);

		return result;
	}
	public void delete(final Tarjeta_Credito tarjeta_Credito) {
		Assert.assertNotNull(tarjeta_Credito);
		Assert.assertEquals(tarjeta_Credito.getId(), 0);

		this.tarjeta_CreditoRepository.delete(tarjeta_Credito);
	}

}
