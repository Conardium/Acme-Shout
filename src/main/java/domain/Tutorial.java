
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Tutorial extends DomainEntity {

	private String	titulo;
	private String	descripcion;
	private String	video;
	private int		contador;


	//------------TITULO
	@NotBlank(message = "El titulo no puede estar en blanco")
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}

	//------------DESCRIPCION
	@NotBlank(message = "La descripcion no puede estar en blanco")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	//------------VIDEO
	@NotBlank(message = "La URL no puede estar en blanco")
	@Pattern(regexp = "^(https?\\:\\/\\/)?(www\\.youtube\\.com|youtu\\.?be)\\/.+$", message = "El enlace debe ser de YouTube")
	public String getVideo() {
		return this.video;
	}

	public void setVideo(final String video) {
		this.video = video;
	}

	//------------CONTADOR
	@Min(0)
	public int getContador() {
		return this.contador;
	}

	public void setContador(final int contador) {
		this.contador = contador;
	}
}
