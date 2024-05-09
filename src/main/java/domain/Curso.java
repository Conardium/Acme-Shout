
package domain;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Curso extends DomainEntity {

	private String			titulo;
	private Estilo			estilo;
	private Nivel			nivel;
	private Date			fechaInicio;
	private Date			fechaFin;
	private DiaSemana		diaSemana;
	private Time			hora;
	private Set<Solicitud>	solicitudes;

	//------------TITULO
	@NotBlank
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}

	//------------ESTILO
	@ManyToOne
	public Estilo getEstilo() {
		return this.estilo;
	}

	public void setEstilo(final Estilo estilo) {
		this.estilo = estilo;
	}

	//------------NIVEL
	public Nivel getNivel() {
		return this.nivel;
	}

	public void setNivel(final Nivel nivel) {
		this.nivel = nivel;
	}

	//------------FECHA INICIO
	@Past
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(final Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	//------------FECHA FIN
	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(final Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	//------------DIA SEMANA
	public DiaSemana getDiaSemana() {
		return this.diaSemana;
	}

	public void setDiaSemana(final DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}

	//------------HORA
	public Time getHora() {
		return this.hora;
	}

	public void setHora(final Time hora) {
		this.hora = hora;
	}

	//------------SOLICITUDES
	@OneToMany(mappedBy = "curso")
	public Set<Solicitud> getSolicitudes() {
		return this.solicitudes;
	}

	public void setSolicitudes(final Set<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}
}
