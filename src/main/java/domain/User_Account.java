
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class User_Account extends DomainEntity {

	private String	nombreUsuario;
	private String	contrasenia;


	//-----------------Nombre Usuario
	@NotBlank
	@Size(min = 5, max = 32)
	@Column(unique = true)
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(final String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	//-----------------Contraseña

	@NotBlank
	@Size(min = 5, max = 32)
	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(final String contrasenia) {
		this.contrasenia = contrasenia;
	}
}
