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

import domain.Estilo;
import services.EstiloService;

@Controller
@RequestMapping("/estilo")
public class EstiloController extends AbstractController {

	@Autowired
	private EstiloService estiloService;


	// Constructors -----------------------------------------------------------

	public EstiloController() {
		super();
	}

	// Listar todos los estilos ---------------------------------------------------------------

	@RequestMapping("/allstyles")
	public ModelAndView ListarTodosLosEstilos() {

		ModelAndView result;

		result = new ModelAndView("listofstyles/allstyles");
		result.addObject("estilos", this.estiloService.findAll());

		return result;
	}

	// Crear Curso form ---------------------------------------------------------------

	@RequestMapping("/form_create_style")
	public ModelAndView form_sing_up_student() {
		ModelAndView result;

		result = new ModelAndView("create_edit_style/form_create_style");
		result.addObject("estilo", this.estiloService.create());

		return result;
	}

	// Crear estilo ---------------------------------------------------------------

	@RequestMapping("/create_style")
	public ModelAndView sing_up_student(@ModelAttribute("Estilo") final Estilo estilo, final BindingResult resultado) {
		ModelAndView result;

		result = new ModelAndView("welcome/index");

		if (resultado.hasErrors())
			result = new ModelAndView("create_edit_style/form_create_style");
		else
			result = new ModelAndView("welcome/index");

		this.estiloService.save(estilo);

		return result;
	}

	//Modificar Estilo form

	@RequestMapping("/form_edit_style")
	public ModelAndView form_edit_alumno(@RequestParam(required = true) final int cursoId) {
		ModelAndView result;

		result = new ModelAndView("create_edit_style/form_edit_style");
		result.addObject("estilo", this.estiloService.findOne(cursoId));

		return result;
	}

	//Modificar Estilo

	@RequestMapping("/edit_style")
	public ModelAndView edit_alumno(@ModelAttribute("Estilo") final Estilo estilo, final BindingResult resultado) {
		ModelAndView result;

		if (resultado.hasErrors())
			result = new ModelAndView("create_edit_style/form_edit_style");
		else
			result = new ModelAndView("welcome/index");

		this.estiloService.save(estilo);

		return result;
	}

	//Borrar Estilo

	@RequestMapping("/delete_style")
	public ModelAndView delete_style(@ModelAttribute("Estilo") final Estilo estilo) {
		ModelAndView result;

		result = new ModelAndView("welcome/index");

		this.estiloService.delete(estilo);

		return result;
	}

}
