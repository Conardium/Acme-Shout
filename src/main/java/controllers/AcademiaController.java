
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Academia;
import services.AcademiaService;

@Controller
@RequestMapping("/academia")
public class AcademiaController extends AbstractController {

	@Autowired
	private AcademiaService academiaService;


	// Constructors -----------------------------------------------------------

	public AcademiaController() {
		super();
	}

	//Crear academia form

	@RequestMapping("/form_sing_up_academy")
	public ModelAndView form_sing_up_student() {
		ModelAndView result;

		result = new ModelAndView("create_edit_actor/form_sing_up_academy");
		result.addObject("academia", this.academiaService.create());

		return result;
	}

	//Crear academia

	@RequestMapping("/sing_up_academy")
	public ModelAndView sing_up_student(@ModelAttribute("academia") final Academia academia, final BindingResult resultado) {
		ModelAndView result;

		if (resultado.hasErrors())
			result = new ModelAndView("create_edit_actor/form_sing_up_academy");
		else
			result = new ModelAndView("welcome/index");

		return result;
	}

	// AllAcademies ---------------------------------------------------------------

	@RequestMapping(value = "/allacademies", method = RequestMethod.GET)
	public ModelAndView allacademies() {

		ModelAndView result;

		result = new ModelAndView("listofacademies/allacademies");
		result.addObject("academias", this.academiaService.findAll());

		return result;
	}

	@RequestMapping(value = "/academybycourse", method = RequestMethod.GET)
	public ModelAndView academybycourse(@RequestParam(required = true) final int cursoId) {

		ModelAndView result;

		result = new ModelAndView("academia/academybycourse");
		result.addObject("academia", this.academiaService.findAcademiaporCurso(cursoId));

		return result;
	}
}
