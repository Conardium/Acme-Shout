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
import org.springframework.web.servlet.ModelAndView;

import domain.Alumno;
import domain.Tarjeta_Credito;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import services.AlumnoService;
import services.Tarjeta_CreditoService;

@Controller
@RequestMapping("/tarjeta")
public class Tarjeta_CreditoController extends AbstractController {

	@Autowired
	private Tarjeta_CreditoService	tarjetaService;
	@Autowired
	private AlumnoService			alumnoService;


	// Constructors -----------------------------------------------------------

	public Tarjeta_CreditoController() {
		super();
	}

	//Mostrar Tarjeta

	@RequestMapping("/show_creditcard")
	public ModelAndView show_creditcard() {
		ModelAndView result;

		final UserAccount aux = LoginService.getPrincipal();

		if (aux.getAuth() == Authority.ALUMNO) {
			result = new ModelAndView("creditcard/creditcard");
			result.addObject("esAlumno", true);
			result.addObject("esAcademia", false);
			result.addObject("esAdmin", false);
		} else
			result = new ModelAndView("welcome/index");

		result.addObject("tarjeta", this.alumnoService.findByAccountId(aux.getId()).getTarjetaCredito());

		return result;
	}

	//Modificar Tarjeta form

	@RequestMapping("/form_edit_creditcard")
	public ModelAndView form_edit_creditcard() {
		ModelAndView result;

		if (LoginService.haySesionIniciada() && LoginService.getPrincipal().getAuth().equals("ALUMNO")) {
			result = new ModelAndView("create_edit_creditcard/form_edit_creditcard");
			result.addObject("esAlumno", true);
			result.addObject("esAcademia", false);
			result.addObject("esAdmin", false);

			final UserAccount aux = LoginService.getPrincipal();
			result.addObject("tarjeta", this.alumnoService.findByAccountId(aux.getId()).getTarjetaCredito());
		} else
			result = new ModelAndView("welcome/index");

		return result;
	}

	//Modificar Tarjeta

	@RequestMapping("/edit_creditcard")
	public ModelAndView edit_creditcard(@ModelAttribute("Tarjeta_Credito") final Tarjeta_Credito tarjeta, final BindingResult resultado) {
		ModelAndView result;

		if (LoginService.haySesionIniciada() && LoginService.getPrincipal().getAuth().equals("ALUMNO")) {
			if (resultado.hasErrors())
				result = new ModelAndView("create_edit_creditcard/form_edit_creditcard");
			else {
				final UserAccount aux = LoginService.getPrincipal();
				Alumno alumno = this.alumnoService.findByAccountId(aux.getId());
				result = new ModelAndView("student/student");

				tarjeta.setNombreTitular(alumno.getNombre() + " " + alumno.getApellidos());

				alumno.setTarjetaCredito(this.tarjetaService.save(tarjeta));
				this.alumnoService.save(alumno);
			}
		} else
			result = new ModelAndView("welcome/index");

		return result;
	}

}
