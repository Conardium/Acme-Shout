
package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Comentario;
import services.ComentarioService;

@Controller
@RequestMapping("/comentarios")
public class ComentarioController {

	@Autowired
	private ComentarioService comentarioService;


	@RequestMapping("/listarTodos")
	public String listarComentarios(final Model model) {
		final Collection<Comentario> comentarios = this.comentarioService.findAll();
		model.addAttribute("comentarios", comentarios);
		model.addAttribute("nuevoComentario", new Comentario());
		return "gestionarComentarios";
	}

	@RequestMapping("/guardar")
	public String guardarComentario(@Valid @ModelAttribute("nuevoComentario") final Comentario comentario, final BindingResult result, final Model model) {
		if (result.hasErrors()) {
			final Collection<Comentario> comentarios = this.comentarioService.findAll();
			model.addAttribute("comentarios", comentarios);
			return "gestionarComentarios";
		}
		//Actor actor = actorService.findCurrentActor(); // Método para obtener el actor actual
		//comentario.setActor(actor););
		//comentario.setFechaPublicacion(new Date());
		this.comentarioService.save(comentario);
		return "redirect:/comentarios";
	}

	@RequestMapping("/borrar/{id}")
	public String borrarComentario(@PathVariable("id") final int id) {
		this.comentarioService.delete(id);
		return "redirect:/comentarios";
	}
}
