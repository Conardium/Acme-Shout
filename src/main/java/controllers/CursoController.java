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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Curso;
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

	//Mostrar Curso

	@RequestMapping("/show_course")
	public ModelAndView show_academy(@RequestParam(required = true) final int courseId) {
		ModelAndView result;

		result = new ModelAndView("course/course");
		result.addObject("curso", this.cursoService.findOne(courseId));

		return result;
	}

	// Crear Curso form ---------------------------------------------------------------

	@RequestMapping("/form_create_course")
	public ModelAndView form_sing_up_student() {
		ModelAndView result;

		result = new ModelAndView("create_edit_course/form_create_course");
		result.addObject("curso", this.cursoService.create());

		return result;
	}

	// Crear Curso ---------------------------------------------------------------

	@RequestMapping("/create_course")
	public ModelAndView sing_up_course(@ModelAttribute("Curso") final Curso curso, final BindingResult resultado) {
		ModelAndView result;

		result = new ModelAndView("welcome/index");

		if (resultado.hasErrors())
			result = new ModelAndView("create_edit_course/form_create_course");
		else
			result = new ModelAndView("welcome/index");

		this.cursoService.save(curso);

		return result;
	}

	//Modificar Curso form

	@RequestMapping("/form_edit_course")
	public ModelAndView form_edit_course(@RequestParam(required = true) final int cursoId) {
		ModelAndView result;

		result = new ModelAndView("create_edit_course/form_edit_course");
		result.addObject("curso", this.cursoService.findOne(cursoId));

		return result;
	}

	//Modificar Curso

	@RequestMapping("/edit_course")
	public ModelAndView edit_course(@ModelAttribute("Curso") final Curso curso, final BindingResult resultado) {
		ModelAndView result;

		if (resultado.hasErrors())
			result = new ModelAndView("create_edit_course/form_edit_course");
		else
			result = new ModelAndView("welcome/index");

		this.cursoService.save(curso);

		return result;
	}

	//Borrar Curso

	@RequestMapping("/delete_course")
	public ModelAndView delete_course(@ModelAttribute("Curso") final Curso curso) {
		ModelAndView result;

		result = new ModelAndView("welcome/index");

		this.cursoService.delete(curso);

		return result;
	}

	// Listar todos los cursos ---------------------------------------------------------------

	@RequestMapping("/allcourses")
	public ModelAndView listofall() {

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
	public ModelAndView listbyacademy(@RequestParam(required = true) final int academiaId) {

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
	public ModelAndView listbystyle(@RequestParam(required = true) final int estiloId) {

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

	@RequestMapping("/allcoursesfromfilter")
	public ModelAndView listbyfilter(@RequestParam(required = true) final String filtro) {

		ModelAndView result;

		result = new ModelAndView("listofcourses/allcoursesfromfilter");
		result.addObject("cursos", this.cursoService.findCursosByFiltro(filtro));

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
