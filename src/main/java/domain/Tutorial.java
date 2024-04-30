
package domain;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Tutorial extends DomainEntity {

	private String	titulo;
	private String	descripcion;
	private String	video;
	private int		contador;


	//------------TITULO
	@NotBlank
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}

	//------------DESCRIPCION
	@NotBlank
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	//------------VIDEO
	@NotBlank
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
