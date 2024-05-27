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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import services.CursoService;

@Controller
@RequestMapping("/curso")
public class CursoController extends AbstractController {

	@Autowired
	private CursoService cursoService;


	// Constructors -----------------------------------------------------------

	public CursoController() {
		super();
	}

	// Action-1 ---------------------------------------------------------------

	@RequestMapping("/allcourses")
	public ModelAndView action1() {

		ModelAndView result;

		result = new ModelAndView("listofcourses/allcourses");
		result.addObject("cursos", this.cursoService.findAll());

		return result;
	}

	// Action-2 ---------------------------------------------------------------

	@RequestMapping("/action-2B")
	public ModelAndView action2() {
		ModelAndView result;

		result = new ModelAndView("administrator/action-2");

		return result;
	}

}
