
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
		return this.estiloRepository.findAll();
	}
	public Estilo findOne(final int estiloId) {
		return this.estiloRepository.findOne(estiloId);
	}
	public Estilo save(final Estilo estilo) {
		return this.estiloRepository.save(estilo);
	}
	public void delete(final Estilo estilo) {
		this.estiloRepository.delete(estilo);
	}

}
