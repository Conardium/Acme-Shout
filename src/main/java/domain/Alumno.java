
package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Alumno extends Actor {

	private Tarjeta_Credito	tarjetaCredito;
	private List<Solicitud>	solicitudes;


	//-----------------Tarjeta de Credito

	@NotNull
	@OneToOne
	public Tarjeta_Credito getTarjetaCredito() {
		return this.tarjetaCredito;
	}

	public void setTarjetaCredito(final Tarjeta_Credito tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

	//-----------------Solicitudes

	@OneToMany(mappedBy = "alumno")
	public List<Solicitud> getSolicitudes() {
		return this.solicitudes;
	}

	public void setSolicitudes(final List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public void addSolicitud(final Solicitud solicitud) {
		if (this.solicitudes == null)
			this.solicitudes = new ArrayList<>();
		this.solicitudes.add(solicitud);
	}

	public void removeSolicitud(final Solicitud solicitud) {
		if (this.solicitudes != null)
			this.solicitudes.remove(solicitud);
	}
}
