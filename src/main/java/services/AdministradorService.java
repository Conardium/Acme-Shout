
package services;

import java.util.Collection;

import javax.transaction.Transactional;

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
		return null;
	}

	public Collection<Administrador> findAll() {
		return this.administradorRepository.findAll();
	}

	public Administrador findOne(final int administradorId) {
		return this.administradorRepository.findOne(administradorId);
	}
	public Administrador save(final Administrador administrador) {
		return this.administradorRepository.save(administrador);
	}
	public void delete(final Administrador administrador) {
		this.administradorRepository.delete(administrador);
	}
}
