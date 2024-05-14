
package domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Academia extends Actor {

	private String					nombreComercial;
	private Collection<Tutorial>	tutoriales;
	private Collection<Solicitud>	solicitudes;
	private Collection<Curso>		cursos;


	public Academia() {
		super();
		this.tutoriales = new HashSet<Tutorial>();
		this.solicitudes = new HashSet<Solicitud>();
		this.cursos = new HashSet<Curso>();
	}

	//-----------------Nombre Comercial
	@NotBlank(message = "El nombre comercial no puede estar en blanco")
	public String getNombreComercial() {
		return this.nombreComercial;
	}

	public void setNombreComercial(final String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	//-----------------Tutoriales
	@OneToMany
	public Collection<Tutorial> getTutoriales() {
		return this.tutoriales;
	}

	public void setTutoriales(final Collection<Tutorial> tutoriales) {
		this.tutoriales = tutoriales;
	}

	//-----------------Solicitudes
	@OneToMany
	public Collection<Solicitud> getSolicitudes() {
		return this.solicitudes;
	}

	public void setSolicitudes(final Collection<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	//-----------------Cursos
	@OneToMany
	public Collection<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(final Collection<Curso> cursos) {
		this.cursos = cursos;
	}
}
