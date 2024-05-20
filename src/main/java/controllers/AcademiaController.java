/*
 * CustomerController.java
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

import services.AcademiaService;

@Controller
@RequestMapping("/customer")
public class AcademiaController extends AbstractController {

	@Autowired
	private AcademiaService academiaService;


	// Constructors -----------------------------------------------------------

	public AcademiaController() {
		super();
	}

	// AllAcademies ---------------------------------------------------------------

	@RequestMapping("/allacademies")
	public ModelAndView action1() {
		ModelAndView result;

		result = new ModelAndView("listofacademies/allacademies");
		result.addObject("academias", this.academiaService.findAll());

		return result;
	}
}
