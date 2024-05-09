
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Academia extends Actor {

	private String nombreComercial;


	//-----------------Nombre Comercial

	@NotBlank(message = "El nombre comercial no puede estar en blanco")
	public String getNombreComercial() {
		return this.nombreComercial;
	}

	public void setNombreComercial(final String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
}
