/*
 * WelcomeController.java
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

import services.SolicitudService;

@Controller
@RequestMapping("/solicitud")
public class SolicitudController extends AbstractController {

	// Constructors -----------------------------------------------------------

	public SolicitudController() {
		super();
	}


	// Services --------------------------------------------------------------
	@Autowired
	private SolicitudService solicitudService;


	// Index ------------------------------------------------------------------
	@RequestMapping(value = "/allapplications")
	public ModelAndView action1() {
		ModelAndView result;

		result = new ModelAndView("listofapplication/allapplications");
		result.addObject("solicitudes", this.solicitudService.findAll());

		return result;
	}
}
