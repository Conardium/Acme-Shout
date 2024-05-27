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

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import security.Authority;
import services.CursoService;

@Controller
@RequestMapping("/curso")
public class CursoController extends AbstractController {

	@Autowired
	private CursoService cursoService;


	// Constructors -----------------------------------------------------------

	public CursoController() {
		super();
	}

	// Action-1 ---------------------------------------------------------------

	@RequestMapping("/allcourses")
	public ModelAndView action1() {

		ModelAndView result;

		result = new ModelAndView("listofcourses/allcourses");
		result.addObject("cursos", this.cursoService.findAll());

		// Verificar si el usuario está autenticado
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		final boolean isAuthenticated = auth.isAuthenticated() && !auth.getName().equalsIgnoreCase("anonymousUser");
		boolean esAlumno = false;

		// Obtener el nombre de usuario y los roles del usuario
		if (isAuthenticated) {
			final Collection<Authority> authorities = (Collection<Authority>) auth.getAuthorities();
			for (final Authority authority : authorities)
				if (authority.getAuthority().equalsIgnoreCase("ALUMNO")) {
					esAlumno = true;
					break;
				}
		}

		result.addObject("esAlumno", esAlumno);

		result.addObject("yaSolicitada", false);

		result.addObject("yaInscrito", false);

		return result;
	}

	// Action-2 ---------------------------------------------------------------

	@RequestMapping("/allcoursesfromacademy")
	public ModelAndView action2(@RequestParam(required = true) final int academiaId) {

		ModelAndView result;

		result = new ModelAndView("listofcourses/allcoursesfromacademy");
		result.addObject("cursos", this.cursoService.findCursosporAcademia(academiaId));

		// Verificar si el usuario está autenticado
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		final boolean isAuthenticated = auth.isAuthenticated() && !auth.getName().equalsIgnoreCase("anonymousUser");
		boolean esAlumno = false;

		// Obtener el nombre de usuario y los roles del usuario
		if (isAuthenticated) {
			final Collection<Authority> authorities = (Collection<Authority>) auth.getAuthorities();
			for (final Authority authority : authorities)
				if (authority.getAuthority().equalsIgnoreCase("ALUMNO")) {
					esAlumno = true;
					break;
				}
		}

		result.addObject("esAlumno", esAlumno);

		result.addObject("esAcademia", false);

		result.addObject("yaSolicitada", false);

		result.addObject("yaInscrito", false);

		return result;
	}

	@RequestMapping("/allcoursesfromstyle")
	public ModelAndView action3(@RequestParam(required = true) final int estiloId) {

		ModelAndView result;

		result = new ModelAndView("listofcourses/allcoursesfromstyle");
		result.addObject("cursos", this.cursoService.findCursosporEstilo(estiloId));

		// Verificar si el usuario está autenticado
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		final boolean isAuthenticated = auth.isAuthenticated() && !auth.getName().equalsIgnoreCase("anonymousUser");
		boolean esAlumno = false;

		// Obtener el nombre de usuario y los roles del usuario
		if (isAuthenticated) {
			final Collection<Authority> authorities = (Collection<Authority>) auth.getAuthorities();
			for (final Authority authority : authorities)
				if (authority.getAuthority().equalsIgnoreCase("ALUMNO")) {
					esAlumno = true;
					break;
				}
		}

		result.addObject("esAlumno", esAlumno);

		result.addObject("esAcademia", false);

		result.addObject("yaSolicitada", false);

		result.addObject("yaInscrito", false);

		return result;
	}

}
