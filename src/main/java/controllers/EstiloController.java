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
import security.LoginService;
import security.UserAccount;
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

	// Mostrar estilo ---------------------------------------------------------------

	@RequestMapping("/style")
	public ModelAndView MostrarEstilo(@RequestParam(required = true) final int estiloId) {

		ModelAndView result;

		result = new ModelAndView("style/style");
		result.addObject("estilo", this.estiloService.findOne(estiloId));

		// Verificar si el usuario está autenticado
		try {
			final UserAccount user = LoginService.getPrincipal();
			result.addObject("autoridad", user.getAuth());

		} catch (final Exception ex) {
			//No esta conectado
			result.addObject("autoridad", "NADA");
		}

		return result;
	}

	// Listar todos los estilos ---------------------------------------------------------------

	@RequestMapping("/allstyles")
	public ModelAndView ListarTodosLosEstilos() {

		ModelAndView result;

		result = new ModelAndView("listofstyles/allstyles");
		result.addObject("estilos", this.estiloService.findAll());

		// Verificar si el usuario está autenticado
		try {
			final UserAccount user = LoginService.getPrincipal();
			result.addObject("autoridad", user.getAuth());

		} catch (final Exception ex) {
			//No esta conectado
			result.addObject("autoridad", "NADA");
		}

		return result;
	}

	// Crear Estilo form ---------------------------------------------------------------

	@RequestMapping("/form_create_style")
	public ModelAndView form_create_style() {
		ModelAndView result;

		result = new ModelAndView("create_edit_style/form_create_style");
		result.addObject("estilo", this.estiloService.create());

		return result;
	}

	// Crear Estilo ---------------------------------------------------------------

	@RequestMapping("/create_style")
	public ModelAndView create_style(@ModelAttribute("Estilo") final Estilo estilo, final BindingResult resultado) {
		ModelAndView result;

		result = new ModelAndView("welcome/index");

		if (resultado.hasErrors())
			result = new ModelAndView("create_edit_style/form_create_style");
		else {
			result = new ModelAndView("listofstyles/allstyles");

			final UserAccount user = LoginService.getPrincipal();
			result.addObject("autoridad", user.getAuth());
			this.estiloService.save(estilo);
			result.addObject("estilos", this.estiloService.findAll());
		}

		return result;
	}

	//Modificar Estilo form

	@RequestMapping("/form_edit_style")
	public ModelAndView form_edit_style(@RequestParam(required = true) final int estiloId) {
		ModelAndView result;

		result = new ModelAndView("create_edit_style/form_edit_style");
		result.addObject("estilo", this.estiloService.findOne(estiloId));

		return result;
	}

	//Modificar Estilo

	@RequestMapping("/edit_style")
	public ModelAndView edit_style(@ModelAttribute("Estilo") final Estilo estilo, final BindingResult resultado) {
		ModelAndView result;

		if (resultado.hasErrors()) {
			result = new ModelAndView("create_edit_style/form_edit_style");
			result.addObject("estilo", estilo);
		} else {
			result = new ModelAndView("listofstyles/allstyles");

			final UserAccount user = LoginService.getPrincipal();
			result.addObject("autoridad", user.getAuth());
			this.estiloService.save(estilo);
			result.addObject("estilos", this.estiloService.findAll());
		}

		return result;
	}

	//Borrar Estilo

	@RequestMapping("/delete_style")
	public ModelAndView delete_style(@RequestParam(required = true) final int estiloId) {
		ModelAndView result;

		Estilo estilo = this.estiloService.findOne(estiloId);

		//Ningun Curso debe tener este estilo
		if (this.estiloService.existeCursoConEstilo(estilo))
			result = new ModelAndView("listofstyles/allstyles");
		else {
			result = new ModelAndView("listofstyles/allstyles");
			this.estiloService.delete(estilo);
		}

		final UserAccount user = LoginService.getPrincipal();
		result.addObject("autoridad", user.getAuth());
		result.addObject("estilos", this.estiloService.findAll());
		return result;
	}

}
