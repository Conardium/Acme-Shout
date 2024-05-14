
package domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Estilo extends DomainEntity {

	private String				nombre;
	private String				descripcion;
	private Collection<String>	imagenes;
	private Collection<String>	videos;


	public Estilo() {
		super();
		this.imagenes = new HashSet<String>();
		this.videos = new HashSet<String>();
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
	@ElementCollection
	//@URL
	public Collection<String> getImagenes() {
		return this.imagenes;
	}

	public void setImagenes(final Collection<String> imagenes) {
		this.imagenes = imagenes;
	}

	//------------VIDEOS
	@ElementCollection
	//@URL
	public Collection<String> getVideos() {
		return this.videos;
	}

	public void setVideos(final Collection<String> videos) {
		this.videos = videos;
	}
}
