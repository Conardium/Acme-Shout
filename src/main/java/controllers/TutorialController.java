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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Academia;
import domain.Tutorial;
import security.LoginService;
import security.UserAccount;
import services.AcademiaService;
import services.TutorialService;

@Controller
@RequestMapping("/tutorial")
public class TutorialController extends AbstractController {

	@Autowired
	private TutorialService	tutorialService;
	@Autowired
	private AcademiaService	academiaService;


	// Constructors -----------------------------------------------------------

	public TutorialController() {
		super();
	}

	//Mostrar Tutorial

	@RequestMapping("/show_tutorial")
	public ModelAndView show_academy(@RequestParam(required = true) final int tutorialId) {
		ModelAndView result;

		result = new ModelAndView("tutorial/tutorial");
		Tutorial tutorial = this.tutorialService.findOne(tutorialId);

		result.addObject("tutorial", tutorial);

		tutorial.setContador(tutorial.getContador() + 1);
		tutorial = this.tutorialService.save(tutorial);

		result.addObject("tutorial", tutorial);

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

		if (resultado.hasErrors())
			result = new ModelAndView("create_edit_tutorial/form_create_tutorial");
		else {
			result = new ModelAndView("listoftutorial/alltutorialfromacademy");

			tutorial.setContador(0);

			final UserAccount user = LoginService.getPrincipal();
			final Academia actual = this.academiaService.findByAccountId(user.getId());

			actual.getTutoriales().add(this.tutorialService.save(tutorial));
			this.academiaService.save(actual);
		}
		return result;
	}

	//Modificar Tutorial form

	@RequestMapping("/form_edit_tutorial")
	public ModelAndView form_edit_course(@RequestParam(required = true) final int tutorialId) {
		ModelAndView result;

		result = new ModelAndView("create_edit_tutorial/form_edit_tutorial");
		result.addObject("tutorial", this.tutorialService.findOne(tutorialId));

		return result;
	}

	//Modificar Tutorial

	@RequestMapping("/edit_tutorial")
	public ModelAndView edit_course(@ModelAttribute("Tutorial") final Tutorial tutorial, final BindingResult resultado) {
		ModelAndView result;

		if (resultado.hasErrors())
			result = new ModelAndView("create_edit_tutorial/form_edit_tutorial");
		else {
			result = new ModelAndView("listoftutorial/alltutorialfromacademy");

			final UserAccount user = LoginService.getPrincipal();
			final Academia actual = this.academiaService.findByAccountId(user.getId());

			actual.getTutoriales().add(this.tutorialService.save(tutorial));
			this.academiaService.save(actual);
		}

		return result;
	}

	//Borrar Tutorial

	@RequestMapping("/delete_tutorial")
	public ModelAndView delete_course(@RequestParam(required = true) final int tutorialId) {
		ModelAndView result;

		result = new ModelAndView("listoftutorial/alltutorialfromacademy");

		Tutorial tutorial = this.tutorialService.findOne(tutorialId);
		final UserAccount user = LoginService.getPrincipal();
		Academia actual = this.academiaService.findByAccountId(user.getId());
		actual.getTutoriales().remove(tutorial);

		this.academiaService.save(actual);
		this.tutorialService.delete(tutorial);

		return result;
	}

	// Listar todos los tutoriales por academia ---------------------------------------------------------------

	@RequestMapping("/alltutorialbyacademy")
	public ModelAndView listartutoriales(@RequestParam(required = true) final int idAcademia) {

		ModelAndView result;

		result = new ModelAndView("listoftutorial/alltutorialbyacademy");
		result.addObject("tutoriales", this.tutorialService.findAllByAcademia(idAcademia));

		return result;
	}

	// Listar todos los tutoriales por academia ---------------------------------------------------------------

	@RequestMapping("/alltutorialfromacademy")
	public ModelAndView listartutorialesdeacademia() {

		ModelAndView result;

		// Verificar si el usuario está autenticado
		final UserAccount user = LoginService.getPrincipal();
		Academia actual = this.academiaService.findByAccountId(user.getId());

		result = new ModelAndView("listoftutorial/alltutorialfromacademy");
		result.addObject("tutoriales", this.tutorialService.findAllByAcademia(actual.getId()));

		return result;
	}
}
