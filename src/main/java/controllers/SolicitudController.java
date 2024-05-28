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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Estado;
import domain.Solicitud;
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


	// MOSTAR TODAS LAS SOLICITUDES -------------------------------------------
	@RequestMapping(value = "/allapplications")
	public ModelAndView ListarSolicitudesPorAcademia() {
		ModelAndView result;

		result = new ModelAndView("listofapplication/allapplications");
		result.addObject("solicitudes", this.solicitudService.findAll());

		return result;
	}

	// RECHAZAR SOLICITUD -----------------
	@RequestMapping(value = "/rejectapplication")
	public ModelAndView RechazarSolicitud(@RequestParam("idSolicitud") final int idSolicitud) {
		ModelAndView result;

		final Solicitud solicitud = this.solicitudService.findOne(idSolicitud);
		if (solicitud != null) {
			solicitud.setEstado(Estado.Rechazado);
			this.solicitudService.save(solicitud);
		}

		result = new ModelAndView("listofapplication/allapplications");
		result.addObject("solicitudes", this.solicitudService.findAll());
		return result;
	}

	// ACEPTAR SOLICITUD -----------------
	@RequestMapping(value = "/acceptapplication")
	public ModelAndView aceptarSolicitud(@RequestParam("idSolicitud") final int idSolicitud) {
		ModelAndView result;

		final Solicitud solicitud = this.solicitudService.findOne(idSolicitud);
		if (solicitud != null) {
			solicitud.setEstado(Estado.Aceptado);
			this.solicitudService.save(solicitud);
		}

		result = new ModelAndView("listofapplication/allapplications");
		result.addObject("solicitudes", this.solicitudService.findAll());
		return result;
	}
}
