
package domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import security.UserAccount;

@Entity
@Access(AccessType.PROPERTY)
public abstract class Actor extends DomainEntity {

	private String					nombre;
	private String					apellidos;
	private String					correo;
	private String					telefono;
	private String					direccionPostal;

	private Collection<Comentario>	comentarios;
	private Collection<Actor>		suscritos;

	private UserAccount				userAccount;


	public Actor() {
		super();
		this.comentarios = new HashSet<Comentario>();
		this.suscritos = new HashSet<Actor>();
	}

	//----------------UserAccount
	@OneToOne(optional = false)
	public UserAccount getUserAccount() {
		return this.userAccount;
	}
	public void setUserAccount(final UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	//----------------Comentarios
	@OneToMany(mappedBy = "actor")
	public Collection<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(final Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	//----------------Suscritos
	@ManyToMany
	public Collection<Actor> getSuscritos() {
		return this.suscritos;
	}

	public void setSuscritos(final Collection<Actor> suscritos) {
		this.suscritos = suscritos;
	}

	//----------------Nombre
	@NotBlank(message = "El nombre no puede estar en blanco")
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	//----------------Apellidos
	@NotBlank(message = "Los apellidos no pueden estar en blanco")
	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(final String apellidos) {
		this.apellidos = apellidos;
	}

	//----------------Correo
	@Pattern(regexp = ".+@.+\\..+", message = "El correo debe tener un formato válido")
	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(final String correo) {
		this.correo = correo;
	}

	//-----------------Telefono
	@Pattern(regexp = "\\d{2}\\s\\d{4,}", message = "El teléfono debe tener un formato válido")
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(final String telefono) {
		this.telefono = telefono;
	}

	//-----------------Codigo Postal
	public String getDireccionPostal() {
		return this.direccionPostal;
	}

	public void setDireccionPostal(final String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}
}
