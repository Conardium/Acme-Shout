
package domain;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Curso extends DomainEntity {

	private String					titulo;
	private Estilo					estilo;
	private Nivel					nivel;
	private Date					fechaInicio;
	private Date					fechaFin;
	private DiaSemana				diaSemana;
	private Time					hora;
	private Collection<Solicitud>	solicitudes;


	public Curso() {
		super();
		this.solicitudes = new HashSet<Solicitud>();
	}

	public Curso(final String horaString) {
		super();
		this.solicitudes = new HashSet<Solicitud>();
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			final Date parsedDate = sdf.parse(horaString);
			this.hora = new Time(parsedDate.getTime());
		} catch (final Exception e) {
		}
	}

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
	@Enumerated(EnumType.STRING)
	public Nivel getNivel() {
		return this.nivel;
	}

	public void setNivel(final Nivel nivel) {
		this.nivel = nivel;
	}

	//------------FECHA INICIO
	@Past
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(final Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	//------------FECHA FIN
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(final Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	//------------DIA SEMANA
	@Enumerated(EnumType.STRING)
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

	@DateTimeFormat(pattern = "HH:mm:ss")
	public void setHora(final Time hora) {
		this.hora = hora;

	}

	//------------SOLICITUDES
	@OneToMany(mappedBy = "curso")
	public Collection<Solicitud> getSolicitudes() {
		return this.solicitudes;
	}

	public void setSolicitudes(final Collection<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}
}
