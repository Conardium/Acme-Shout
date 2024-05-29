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

import domain.Administrador;
import services.AdministradorService;

@Controller
@RequestMapping("/admin")
public class AdministratorController extends AbstractController {

	@Autowired
	private AdministradorService adminService;


	// Constructors -----------------------------------------------------------

	public AdministratorController() {
		super();
	}

	//Mostrar admin

	@RequestMapping("/show_admin")
	public ModelAndView show_admin(@RequestParam(required = true) final int adminId) {
		ModelAndView result;

		result = new ModelAndView("admin/admin");
		result.addObject("admin", this.adminService.findOne(adminId));

		return result;
	}

	//Modificar admin form

	@RequestMapping("/form_edit_admin")
	public ModelAndView form_edit_admin(@RequestParam(required = true) final int adminId) {
		ModelAndView result;

		result = new ModelAndView("create_edit_actor/form_edit_admin");
		result.addObject("admin", this.adminService.findOne(adminId));

		return result;
	}

	//Modificar admin

	@RequestMapping("/edit_admin")
	public ModelAndView edit_admin(@ModelAttribute("admin") final Administrador admin, final BindingResult resultado) {
		ModelAndView result;

		if (resultado.hasErrors())
			result = new ModelAndView("create_edit_actor/form_edit_admin");
		else
			result = new ModelAndView("admin/admin");

		this.adminService.save(admin);

		return result;
	}

	//Modificar admin

	@RequestMapping("/dashboard")
	public ModelAndView dashboard() {
		ModelAndView result;

		result = new ModelAndView("dashboard/dashboard");

		return result;
	}

}
