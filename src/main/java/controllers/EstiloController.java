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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Curso;
import domain.Estilo;
import services.EstiloService;

@Controller
@RequestMapping("/administrator")
public class EstiloController extends AbstractController {

	// Constructors -----------------------------------------------------------

	public EstiloController() {
		super();
	}


	@Autowired
	private EstiloService estiloService;  // Servicio para obtener estilos


	// Action-1 ---------------------------------------------------------------

	@RequestMapping("/action-1")
	public ModelAndView action1() {
		ModelAndView result;

		result = new ModelAndView("administrator/action-1");

		return result;
	}

	// Action-2 ---------------------------------------------------------------

	@RequestMapping("/action-2")
	public ModelAndView action2() {
		ModelAndView result;

		result = new ModelAndView("administrator/action-2");

		return result;
	}

	@RequestMapping(value = "/registerCurso", method = RequestMethod.GET)
	public ModelAndView crearCurso() {
		ModelAndView result;

		result = new ModelAndView("create_edit_course/create_course");

		final Collection<Estilo> estilos = this.estiloService.findAll();  // Obtener todos los estilos

		result.addObject("estilos", estilos);
		result.addObject("curso", new Curso());

		return result;
	}

	@RequestMapping(value = "/registerCurso", method = RequestMethod.POST)
	public String submit(@ModelAttribute("curso") final Curso curso) {

		return "cursoRegistrado";
	}

}
