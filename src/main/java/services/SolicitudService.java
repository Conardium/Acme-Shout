
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
		return null;
	}
	public Solicitud findOne(final int solicitudId) {
		return null;
	}
	public Solicitud save(final Solicitud solicitud) {
		return null;
	}
	public void delete(final Solicitud solicitud) {
		;
	}

}
