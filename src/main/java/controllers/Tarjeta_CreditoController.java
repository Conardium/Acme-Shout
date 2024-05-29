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

import domain.Tarjeta_Credito;
import services.Tarjeta_CreditoService;

@Controller
@RequestMapping("/tarjeta")
public class Tarjeta_CreditoController extends AbstractController {

	@Autowired
	private Tarjeta_CreditoService tarjetaService;


	// Constructors -----------------------------------------------------------

	public Tarjeta_CreditoController() {
		super();
	}

	//Modificar Tarjeta form

	@RequestMapping("/form_edit_tarjeta")
	public ModelAndView form_edit_course(@RequestParam(required = true) final int tarjetaId) {
		ModelAndView result;

		result = new ModelAndView("create_edit_tarjeta/form_edit_tarjeta");
		result.addObject("tarjeta", this.tarjetaService.findOne(tarjetaId));

		return result;
	}

	//Modificar Tarjeta

	@RequestMapping("/edit_tutorial")
	public ModelAndView edit_course(@ModelAttribute("Tarjeta") final Tarjeta_Credito tarjeta, final BindingResult resultado) {
		ModelAndView result;

		if (resultado.hasErrors())
			result = new ModelAndView("create_edit_tarjeta/form_edit_tarjeta");
		else
			result = new ModelAndView("welcome/index");

		this.tarjetaService.save(tarjeta);

		return result;
	}

}
