
package domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

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
	@URL
	public Collection<String> getImagenes() {
		return this.imagenes;
	}

	public void setImagenes(final Set<String> imagenes) {
		this.imagenes = imagenes;
	}

	//------------VIDEOS
	@URL
	public Collection<String> getVideos() {
		return this.videos;
	}

	public void setVideos(final Set<String> videos) {
		this.videos = videos;
	}
}
