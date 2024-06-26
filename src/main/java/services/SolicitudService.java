
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Assert;
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
	public SolicitudService() {
		super();
	}
	public Solicitud create() {
		Solicitud result;

		result = new Solicitud();

		return result;
	}
	public Collection<Solicitud> findAll() {
		Collection<Solicitud> result;

		Assert.assertNotNull(this.solicitudRepository);
		result = this.solicitudRepository.findAll();
		Assert.assertNotNull(result);

		return result;
	}
	public Solicitud findOne(final int solicitudId) {
		Solicitud result;

		result = this.solicitudRepository.findOne(solicitudId);

		return result;
	}
	public Solicitud save(final Solicitud solicitud) {
		Assert.assertNotNull(solicitud);

		Solicitud result;

		result = this.solicitudRepository.save(solicitud);

		return result;
	}
	public void delete(final Solicitud solicitud) {
		Assert.assertNotNull(solicitud);
		Assert.assertEquals(solicitud.getId(), 0);

		this.solicitudRepository.delete(solicitud);
	}

	public Collection<Solicitud> findAllSolicitudesByAcademia(final int academiaId) {
		Collection<Solicitud> result;

		result = this.solicitudRepository.findAllSolicitudesByAcademia(academiaId);

		return result;
	}

	public Collection<Solicitud> findAllSolicitudesByAlumno(final int idAlumno) {
		Collection<Solicitud> result;

		result = this.solicitudRepository.findSolicitudPorAlumno(idAlumno);

		return result;
	}
}
