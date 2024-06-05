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

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Academia;
import domain.Alumno;
import domain.Curso;
import domain.Estado;
import domain.Solicitud;
import security.LoginService;
import security.UserAccount;
import services.AcademiaService;
import services.AlumnoService;
import services.CursoService;
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
	private SolicitudService	solicitudService;
	@Autowired
	private AcademiaService		academiaService;
	@Autowired
	private AlumnoService		alumnoService;
	@Autowired
	private CursoService		cursoService;


	// Solicitar -------------------------------------------
	@RequestMapping(value = "/apply")
	public ModelAndView Solicitar(@RequestParam(required = true) final int idCurso) {
		ModelAndView result;

		if (LoginService.haySesionIniciada() && LoginService.getPrincipal().getAuth().equals("ALUMNO")) {

			final UserAccount user = LoginService.getPrincipal();
			final Alumno alumno = this.alumnoService.findByAccountId(user.getId());
			final Curso curso = this.cursoService.findOne(idCurso);
			final Academia academia = this.academiaService.findAcademiaporCurso(idCurso);

			Solicitud nuevaSolicitud = this.solicitudService.create();

			nuevaSolicitud.setCurso(curso);
			nuevaSolicitud.setEstado(Estado.Pendiente);
			nuevaSolicitud.setFecha(new Date());
			nuevaSolicitud = this.solicitudService.save(nuevaSolicitud);

			curso.getSolicitudes().add(nuevaSolicitud);
			alumno.addSolicitud(nuevaSolicitud);
			academia.getSolicitudes().add(nuevaSolicitud);

			this.alumnoService.save(alumno);
			this.cursoService.save(curso);
			this.academiaService.save(academia);

			result = new ModelAndView("listofapplication/listofapplicationbystudent");
			result.addObject("solicitudes", this.solicitudService.findAllSolicitudesByAlumno(alumno.getId()));
		} else
			result = new ModelAndView("welcome/index");

		return result;
	}

	// RECHAZAR SOLICITUD -----------------
	@RequestMapping(value = "/rejectapplication")
	public ModelAndView RechazarSolicitud(@RequestParam(required = true) final int idSolicitud) {
		ModelAndView result;

		if (LoginService.haySesionIniciada() && LoginService.getPrincipal().getAuth().equals("ACADEMIA")) {

			final UserAccount user = LoginService.getPrincipal();
			Solicitud solicitud = this.solicitudService.findOne(idSolicitud);
			if (solicitud != null) {
				solicitud.setEstado(Estado.Rechazado);
				solicitud = this.solicitudService.save(solicitud);
			}

			result = new ModelAndView("listofapplication/listofapplicationbyacademy");
			Academia academia = this.academiaService.findByAccountId(user.getId());
			result.addObject("solicitudes", this.solicitudService.findAllSolicitudesByAcademia(academia.getId()));
		} else
			result = new ModelAndView("welcome/index");

		return result;
	}

	// ACEPTAR SOLICITUD -----------------
	@RequestMapping(value = "/acceptapplication")
	public ModelAndView aceptarSolicitud(@RequestParam(required = true) final int idSolicitud) {
		ModelAndView result;

		if (LoginService.haySesionIniciada() && LoginService.getPrincipal().getAuth().equals("ACADEMIA")) {

			final UserAccount user = LoginService.getPrincipal();
			Solicitud solicitud = this.solicitudService.findOne(idSolicitud);
			if (solicitud != null) {
				solicitud.setEstado(Estado.Aceptado);
				solicitud = this.solicitudService.save(solicitud);
			}

			result = new ModelAndView("listofapplication/listofapplicationbyacademy");
			Academia academia = this.academiaService.findByAccountId(user.getId());
			result.addObject("solicitudes", this.solicitudService.findAllSolicitudesByAcademia(academia.getId()));
		} else
			result = new ModelAndView("welcome/index");

		return result;
	}
}
