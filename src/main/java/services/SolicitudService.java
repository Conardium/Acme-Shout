
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Solicitud;
import repositories.SolicitudRepository;

@Service
@Transactional
public class SolicitudService {

	// Managed repository -------------------------------

	@Autowired
	private SolicitudRepository solicitudRepository;

	// Supporting services ------------------------------


	// Simple CRUD methods ------------------------------
	public Solicitud create() {
		return null;
	}
	public Collection<Solicitud> findAll() {
		return this.solicitudRepository.findAll();
	}
	public Solicitud findOne(final int solicitudId) {
		return this.solicitudRepository.findOne(solicitudId);
	}
	public Solicitud save(final Solicitud solicitud) {
		return this.solicitudRepository.save(solicitud);
	}
	public void delete(final Solicitud solicitud) {
		this.solicitudRepository.delete(solicitud);
	}

}
