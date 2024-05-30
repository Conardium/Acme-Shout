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

import domain.Alumno;
import domain.Estado;
import domain.Solicitud;
import security.LoginService;
import security.UserAccount;
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
	private AlumnoService		alumnoService;
	private CursoService		cursoService;


	// Solicitar -------------------------------------------
	@RequestMapping(value = "/apply")
	public ModelAndView Solicitar(@RequestParam(required = true) final int idCurso) {
		ModelAndView result;

		final UserAccount user = LoginService.getPrincipal();
		final Alumno actual = this.alumnoService.findByAccountId(user.getId());

		final Solicitud nuevaSolicitud = this.solicitudService.create();

		nuevaSolicitud.setCurso(this.cursoService.findOne(idCurso));
		nuevaSolicitud.setEstado(Estado.Pendiente);
		nuevaSolicitud.setFecha(new Date());

		actual.addSolicitud(nuevaSolicitud);

		this.solicitudService.save(nuevaSolicitud);
		this.alumnoService.save(actual);

		result = new ModelAndView("listofcourses/allcourses");

		return result;
	}

	// RECHAZAR SOLICITUD -----------------
	@RequestMapping(value = "/rejectapplication")
	public ModelAndView RechazarSolicitud(@RequestParam(required = true) final int idSolicitud) {
		ModelAndView result;

		final Solicitud solicitud = this.solicitudService.findOne(idSolicitud);
		if (solicitud != null) {
			solicitud.setEstado(Estado.Rechazado);
			this.solicitudService.save(solicitud);
		}

		result = new ModelAndView("listofapplication/allapplicationsbyacademy");
		result.addObject("solicitudes", this.solicitudService.findAll());
		return result;
	}

	// ACEPTAR SOLICITUD -----------------
	@RequestMapping(value = "/acceptapplication")
	public ModelAndView aceptarSolicitud(@RequestParam(required = true) final int idSolicitud) {
		ModelAndView result;

		final Solicitud solicitud = this.solicitudService.findOne(idSolicitud);
		if (solicitud != null) {
			solicitud.setEstado(Estado.Aceptado);
			this.solicitudService.save(solicitud);
		}

		result = new ModelAndView("listofapplication/allapplicationsbyacademy");
		result.addObject("solicitudes", this.solicitudService.findAll());
		return result;
	}
}
