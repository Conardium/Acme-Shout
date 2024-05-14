
package domain;

import java.util.Set;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
public class Estilo extends DomainEntity {

	private String		nombre;
	private String		descripcion;
	private Set<String>	imagenes;
	private Set<String>	videos;


	public Estilo(final Set<String> imagenes, final Set<String> videos) {
		super();
		this.imagenes = new Set<String>();
		this.videos = videos;
	}

	//------------NOMBRE
	@NotBlank(message = "El nombre no puede estar en blanco")
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	//------------DESCRIPCION
	@NotBlank(message = "La descripcion no puede estar en blanco")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	//------------IMAGENES
	@URL
	public Set<String> getImagenes() {
		return this.imagenes;
	}

	public void setImagenes(final Set<String> imagenes) {
		this.imagenes = imagenes;
	}

	//------------VIDEOS
	@URL
	public Set<String> getVideos() {
		return this.videos;
	}

	public void setVideos(final Set<String> videos) {
		this.videos = videos;
	}
}
