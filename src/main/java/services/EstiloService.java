
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
	private EstiloRepository	estiloRepository;

	// Supporting services ------------------------------
	@Autowired
	private CursoService		cursoService;


	// Simple CRUD methods ------------------------------
	public EstiloService() {
		super();
	}

	public Estilo create() {
		Estilo result;

		result = new Estilo();

		return result;
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

	public boolean existeCursoConEstilo(final Estilo estilo) {
		boolean result;

		result = this.cursoService.existeCursoConEstilo(estilo);

		return result;
	}

	public void delete(final Estilo estilo) {
		Assert.assertNotNull(estilo);
		Assert.assertNotEquals(estilo.getId(), 0);

		//Comprobamos antes de borrar el estilo que este no pertenezca a ningun curso
		Assert.assertTrue(!this.cursoService.existeCursoConEstilo(estilo));

		this.estiloRepository.delete(estilo);
	}

}
