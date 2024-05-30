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
import services.AcademiaService;
import services.AdministradorService;
import services.AlumnoService;
import services.CursoService;
import services.SolicitudService;
import services.TutorialService;

@Controller
@RequestMapping("/admin")
public class AdministratorController extends AbstractController {

	@Autowired
	private AdministradorService	adminService;
	private CursoService			cursoService;
	private AcademiaService			academiaService;
	private SolicitudService		solicitudService;
	private TutorialService			tutorialService;
	private AlumnoService			alumnoService;


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
		result.addObject("minSolicitudPorCurso", this.cursoService.findMinSolicitudesByCurso());
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
		final double mediaComentarios = this.academiaService.getAvgComentariosPorAcademia() + this.alumnoService.getAvgComentariosPorAlumno();
		result.addObject("mediaComentariosPorActor", mediaComentarios);

		//NUMERO MEDIO DE SUSCRIPTORES POR ACTOR
		final double mediaSuscriptores = this.academiaService.getAvgSuscriptoresPorAcademia() + this.alumnoService.getAvgSuscripcionesPorAlumno();
		result.addObject("mediaSuscriptoresPorActor", mediaSuscriptores);

		return result;
	}

}
