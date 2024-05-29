/*
 * AdministratorController.java
 *
 * Copyright (C) 2018 Universidad de Sevilla
 *
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Tutorial;
import security.Authority;
import services.TutorialService;

@Controller
@RequestMapping("/tutorial")
public class TutorialController extends AbstractController {

	@Autowired
	private TutorialService tutorialService;


	// Constructors -----------------------------------------------------------

	public TutorialController() {
		super();
	}

	//Mostrar Tutorial

	@RequestMapping("/show_tutorial")
	public ModelAndView show_academy(@RequestParam(required = true) final int tutorialId) {
		ModelAndView result;

		result = new ModelAndView("tutorial/tutorial");
		result.addObject("tutorial", this.tutorialService.findOne(tutorialId));

		return result;
	}

	// Crear Tutorial form ---------------------------------------------------------------

	@RequestMapping("/form_create_tutorial")
	public ModelAndView form_sing_up_student() {
		ModelAndView result;

		result = new ModelAndView("create_edit_tutorial/form_create_tutorial");
		result.addObject("tutorial", this.tutorialService.create());

		return result;
	}

	// Crear Tutorial ---------------------------------------------------------------

	@RequestMapping("/create_tutorial")
	public ModelAndView sing_up_course(@ModelAttribute("Tutorial") final Tutorial tutorial, final BindingResult resultado) {
		ModelAndView result;

		result = new ModelAndView("welcome/index");

		if (resultado.hasErrors())
			result = new ModelAndView("create_edit_tutorial/form_create_tutorial");
		else
			result = new ModelAndView("welcome/index");

		this.tutorialService.save(tutorial);

		return result;
	}

	//Modificar Tutorial form

	@RequestMapping("/form_edit_tutorial")
	public ModelAndView form_edit_course(@RequestParam(required = true) final int cursoId) {
		ModelAndView result;

		result = new ModelAndView("create_edit_tutorial/form_edit_tutorial");
		result.addObject("tutorial", this.tutorialService.findOne(cursoId));

		return result;
	}

	//Modificar Tutorial

	@RequestMapping("/edit_tutorial")
	public ModelAndView edit_course(@ModelAttribute("Tutorial") final Tutorial tutorial, final BindingResult resultado) {
		ModelAndView result;

		if (resultado.hasErrors())
			result = new ModelAndView("create_edit_tutorial/form_edit_tutorial");
		else
			result = new ModelAndView("welcome/index");

		this.tutorialService.save(tutorial);

		return result;
	}

	//Borrar Tutorial

	@RequestMapping("/delete_tutorial")
	public ModelAndView delete_course(@ModelAttribute("Tutorial") final Tutorial tutorial) {
		ModelAndView result;

		result = new ModelAndView("welcome/index");

		this.tutorialService.delete(tutorial);

		return result;
	}

	// Listar todos los tutoriales por academia ---------------------------------------------------------------

	@RequestMapping("/alltutorialfromacademy")
	public ModelAndView action2(@RequestParam(required = true) final int tutorialId) {

		ModelAndView result;

		result = new ModelAndView("listoftutorial/alltutorialfromacademy");
		result.addObject("tutorial", this.tutorialService.findAllByAcademia(tutorialId));

		// Verificar si el usuario está autenticado
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		final boolean isAuthenticated = auth.isAuthenticated() && !auth.getName().equalsIgnoreCase("anonymousUser");
		boolean esAlumno = false;

		// Obtener el nombre de usuario y los roles del usuario
		if (isAuthenticated) {
			final Collection<Authority> authorities = (Collection<Authority>) auth.getAuthorities();
			for (final Authority authority : authorities)
				if (authority.getAuthority().equalsIgnoreCase("ALUMNO")) {
					esAlumno = true;
					break;
				}
		}

		result.addObject("esAlumno", esAlumno);

		result.addObject("esAcademia", false);

		result.addObject("yaSolicitada", false);

		result.addObject("yaInscrito", false);

		return result;
	}
}
