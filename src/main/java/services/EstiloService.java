
package services;

import java.util.Collection;

import javax.transaction.Transactional;

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
		return null;
	}
	public Estilo findOne(final int estiloId) {
		return null;
	}
	public Estilo save(final Estilo estilo) {
		return null;
	}
	public void delete(final Estilo estilo) {
		;
	}

}
