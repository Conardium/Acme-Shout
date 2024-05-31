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

import domain.Administrador;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import services.AcademiaService;
import services.AdministradorService;
import services.AlumnoService;
import services.CursoService;
import services.TutorialService;

@Controller
@RequestMapping("/admin")
public class AdministratorController extends AbstractController {

	@Autowired
	private AdministradorService	adminService;
	@Autowired
	private CursoService			cursoService;
	@Autowired
	private AcademiaService			academiaService;
	@Autowired
	private TutorialService			tutorialService;
	@Autowired
	private AlumnoService			alumnoService;
	@Autowired
	private LoginService			loginService;


	// Constructors -----------------------------------------------------------

	public AdministratorController() {
		super();
	}

	//Mostrar perfil

	@RequestMapping("/show_profile")
	public ModelAndView show_profile() {
		ModelAndView result;

		final UserAccount aux = LoginService.getPrincipal();

		if (aux.getAuth() == Authority.ADMINISTRADOR) {
			result = new ModelAndView("admin/admin");
			result.addObject("esAlumno", false);
			result.addObject("esAcademia", false);
			result.addObject("esAdmin", true);
		} else
			result = new ModelAndView("welcome/index");

		result.addObject("admin", this.adminService.findByAccountId(aux.getId()));

		return result;
	}

	//Modificar admin form

	@RequestMapping("/form_edit_admin")
	public ModelAndView form_edit_admin() {
		ModelAndView result;
		result = new ModelAndView("create_edit_actor/form_edit_admin");

		final UserAccount aux = LoginService.getPrincipal();
		result.addObject("admin", this.adminService.findByAccountId(aux.getId()));

		return result;
	}

	//Modificar admin

	@RequestMapping("/edit_admin")
	public ModelAndView edit_admin(@ModelAttribute("admin") final Administrador admin, final BindingResult resultado) {
		ModelAndView result;

		if (resultado.hasErrors()) {
			result = new ModelAndView("create_edit_actor/form_edit_admin");
			result.addObject("admin", admin);
		} else {
			final UserAccount user = LoginService.getPrincipal();
			UserAccount.generateMD5Hash(admin.getUserAccount().getPassword(), user);
			user.setUsername(admin.getUserAccount().getUsername());

			result = new ModelAndView("admin/admin");

			admin.setUserAccount(this.loginService.save(user));
			result.addObject("admin", this.adminService.save(admin));

			result.addObject("autoridad", user.getAuth());
		}

		return result;
	}

	//Dashboard admin

	@RequestMapping("/dashboard")
	public ModelAndView dashboard() {
		ModelAndView result;

		result = new ModelAndView("dashboard/dashboard");

		//CURSO POR ACADEMIA
		result.addObject("minimoCursoPorAcademia", this.academiaService.findMinCursosByAcademia());
		result.addObject("mediaCursoPorAcademia", this.academiaService.findAvgCursosByAcademia());
		result.addObject("stdDevCursoPorAcademia", this.academiaService.findStdDevCursosByAcademia());
		result.addObject("maxCursoPorAcademia", this.academiaService.findMaxCursosByAcademia());

		//SOLICITUD POR CURSO
		result.addObject("minSolicitudPorCurso", this.cursoService.findMinSolicitudesByCurso());//FALLA
		result.addObject("mediaSolicitudPorCuros", this.cursoService.findAvgSolicitudesByCurso());
		result.addObject("minSolicitudPorCurso", this.cursoService.findStdDevSolicitudesByCurso());
		result.addObject("minSolicitudPorCurso", this.cursoService.findMaxSolicitudesByCurso());

		//TUTORIAL POR ACADEMIA
		result.addObject("minTutorialPorAcademia", this.academiaService.findMinTutorialesByAcademia());
		result.addObject("mediaTutorialPorAcademia", this.academiaService.findAvgTutorialesByAcademia());
		result.addObject("maxTutorialPorAcademia", this.academiaService.findMaxTutorialesByAcademia());

		//VECES QUE SE MUESTRAN TUTORIALES
		result.addObject("minTutorialVecesMostrado", this.tutorialService.findMinVecesMostrado());
		result.addObject("mediaTutorialVecesMostrado", this.tutorialService.findAvgVecesMostrado());
		result.addObject("maxTutorialVecesMostrado", this.tutorialService.findMaxVecesMostrado());

		//LISTADO DE TUTORIALES ORDENADOS DESCENDENTE
		result.addObject("listaTutoriales", this.tutorialService.findAllOrderByVecesMostradoDesc());

		//NUMERO MEDIO DE COMENTARIOS POR ACTOR
		final double mediaComentarios = (this.academiaService.getAvgComentariosPorAcademia() + this.alumnoService.getAvgComentariosPorAlumno()) / 2;
		result.addObject("mediaComentariosPorActor", mediaComentarios);

		//NUMERO MEDIO DE SUSCRIPTORES POR ACTOR
		final double mediaSuscriptores = (this.academiaService.getAvgSuscriptoresPorAcademia() + this.alumnoService.getAvgSuscripcionesPorAlumno()) / 2;
		result.addObject("mediaSuscriptoresPorActor", mediaSuscriptores);

		return result;
	}

}
