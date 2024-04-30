
package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
public class Comentario extends DomainEntity {

	private Date	fechaPublicacion;
	private String	texto;
	private Actor	actor;


	//------------FECHA PUBLICACION
	@Past
	public Date getFechaPublicacion() {
		return this.fechaPublicacion;
	}

	public void setFechaPublicacion(final Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	//------------TEXTO
	@NotBlank
	@Range(min = 1, max = 140)
	public String getTexto() {
		return this.texto;
	}

	public void setTexto(final String texto) {
		this.texto = texto;
	}

	//------------ACTOR
	@ManyToOne
	public Actor getActor() {
		return this.actor;
	}

	public void setActor(final Actor actor) {
		this.actor = actor;
	}
}
