
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Comentario;
import services.ComentarioService;

@Controller
@RequestMapping("/comentario")
public class ComentarioController {

	@Autowired
	private ComentarioService comentarioService;


	//Mostrar Comentario

	@RequestMapping("/show_comment")
	public ModelAndView show_academy(@RequestParam(required = true) final int comentarioId) {
		ModelAndView result;

		result = new ModelAndView("comment/comment");
		result.addObject("curso", this.comentarioService.findOne(comentarioId));

		return result;
	}

	// Crear Comentario form ---------------------------------------------------------------

	@RequestMapping("/form_create_comment")
	public ModelAndView form_sing_up_student() {
		ModelAndView result;

		result = new ModelAndView("create_edit_comment/form_create_comment");
		result.addObject("comentario", this.comentarioService.create());

		return result;
	}

	// Crear Comentario ---------------------------------------------------------------

	@RequestMapping("/create_comment")
	public ModelAndView sing_up_course(@ModelAttribute("Comentario") final Comentario comentario, final BindingResult resultado) {
		ModelAndView result;

		result = new ModelAndView("welcome/index");

		if (resultado.hasErrors())
			result = new ModelAndView("create_edit_comment/form_create_comment");
		else
			result = new ModelAndView("welcome/index");

		this.comentarioService.save(comentario);

		return result;
	}

	//Borrar Comentario

	@RequestMapping("/delete_comment")
	public ModelAndView delete_course(@ModelAttribute("Comentario") final Comentario comentario) {
		ModelAndView result;

		result = new ModelAndView("welcome/index");

		this.comentarioService.delete(comentario);

		return result;
	}

}
