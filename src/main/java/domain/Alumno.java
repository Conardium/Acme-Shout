
package domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Alumno extends Actor {

	private Tarjeta_Credito			tarjetaCredito;
	private Collection<Solicitud>	solicitudes;


	//-----------------Tarjeta de Credito

	public Alumno() {
		super();
		this.solicitudes = new HashSet<Solicitud>();
	}

	@NotNull
	@OneToOne(optional = false)
	public Tarjeta_Credito getTarjetaCredito() {
		return this.tarjetaCredito;
	}

	public void setTarjetaCredito(final Tarjeta_Credito tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

	//-----------------Solicitudes

	@OneToMany
	public Collection<Solicitud> getSolicitudes() {
		return this.solicitudes;
	}

	public void setSolicitudes(final Collection<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public void addSolicitud(final Solicitud solicitud) {
		this.solicitudes.add(solicitud);
	}

	public void removeSolicitud(final Solicitud solicitud) {
		this.solicitudes.remove(solicitud);
	}
}
