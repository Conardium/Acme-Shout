
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Administrador;
import repositories.AdministradorRepository;

@Service
@Transactional
public class AdministradorService {

	// Managed repository -------------------------------
	@Autowired
	private AdministradorRepository administradorRepository;

	// Supporting services ------------------------------


	// Simple CRUD methods ------------------------------
	public Administrador create() {
		Administrador result;

		result = new Administrador();

		return result;
	}

	public Collection<Administrador> findAll() {
		Collection<Administrador> result;

		Assert.assertNotNull(this.administradorRepository);
		result = this.administradorRepository.findAll();
		Assert.assertNotNull(result);

		return result;
	}

	public Administrador findOne(final int administradorId) {
		Administrador result;

		result = this.administradorRepository.findOne(administradorId);

		return result;
	}

	public Administrador save(final Administrador administrador) {
		return this.administradorRepository.save(administrador);
	}

	public void delete(final Administrador administrador) {
		this.administradorRepository.delete(administrador);
	}
}
