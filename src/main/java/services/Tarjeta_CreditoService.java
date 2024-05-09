
package services;

import java.util.Collection;

import javax.transaction.Transactional;

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
		return null;
	}
	public Collection<Tarjeta_Credito> findAll() {
		return null;
	}
	public Tarjeta_Credito findOne(final int tarjeta_CreditoId) {
		return null;
	}
	public Tarjeta_Credito save(final Tarjeta_Credito tarjeta_Credito) {
		return null;
	}
	public void delete(final Tarjeta_Credito tarjeta_Credito) {
		;
	}

}
