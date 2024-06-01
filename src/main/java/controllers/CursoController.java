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

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Academia;
import domain.Curso;
import domain.DiaSemana;
import domain.Estilo;
import domain.Nivel;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import services.AcademiaService;
import services.CursoService;
import services.EstiloService;

@Controller
@RequestMapping("/curso")
public class CursoController extends AbstractController {

	private static final SimpleDateFormat	timeFormat	= new SimpleDateFormat("HH:mm:ss");

	@Autowired
	private CursoService					cursoService;
	@Autowired
	private AcademiaService					academiaService;
	@Autowired
	private EstiloService					estiloService;


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

		// Verificar si el usuario está autenticado
		try {
			final UserAccount user = LoginService.getPrincipal();
			result.addObject("autoridad", user.getAuth());
		} catch (final Exception ex) {
			//No esta conectado
			result.addObject("autoridad", "nada");
		}

		return result;
	}

	// Crear Curso form ---------------------------------------------------------------

	@RequestMapping("/form_create_course")
	public ModelAndView form_sing_up_student() {
		ModelAndView result;

		result = new ModelAndView("create_edit_course/form_create_course");

		Collection<String> niveles = new HashSet<String>();
		for (int i = 0; i < Nivel.values().length; i++)
			niveles.add(Nivel.values()[i].name());
		result.addObject("niveles", niveles);

		Collection<String> dias = new HashSet<String>();
		for (int i = 0; i < DiaSemana.values().length; i++)
			dias.add(DiaSemana.values()[i].name());
		result.addObject("dias", dias);

		result.addObject("curso", this.cursoService.create());
		result.addObject("estilos", this.estiloService.findAll());

		return result;
	}

	// Crear Curso ---------------------------------------------------------------

	@RequestMapping("/create_course")
	public ModelAndView create_course(@ModelAttribute("Curso") final Curso curso, @RequestParam("estiloId") int estiloId, @RequestParam("horaCurso") String horaCurso, final BindingResult resultado) {
		ModelAndView result;

		if (resultado.hasErrors()) {

			result = new ModelAndView("create_edit_course/form_create_course");

			Collection<String> niveles = new HashSet<String>();
			for (int i = 0; i < Nivel.values().length; i++)
				niveles.add(Nivel.values()[i].name());
			result.addObject("niveles", niveles);

			Collection<String> dias = new HashSet<String>();
			for (int i = 0; i < DiaSemana.values().length; i++)
				dias.add(DiaSemana.values()[i].name());
			result.addObject("dias", dias);

			result.addObject("curso", this.cursoService.create());
			result.addObject("estilos", this.estiloService.findAll());
		} else {

			Estilo est = this.estiloService.findOne(estiloId);
			curso.setEstilo(est);

			try {
				Date parsedDate = CursoController.timeFormat.parse(horaCurso);
				curso.setHora(new Time(parsedDate.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			final UserAccount user = LoginService.getPrincipal();
			final Academia actual = this.academiaService.findByAccountId(user.getId());
			actual.getCursos().add(this.cursoService.save(curso));

			this.academiaService.save(actual);

			result = new ModelAndView("listofcourses/allcoursesofprofileacademy");

			result.addObject("cursos", this.cursoService.findCursosporAcademia(this.academiaService.findByAccountId(user.getId()).getId()));
			result.addObject("autoridad", user.getAuth());

		}

		return result;
	}

	//Modificar Curso form

	@RequestMapping("/form_edit_course")
	public ModelAndView form_edit_course(@RequestParam(required = true) final int cursoId) {
		ModelAndView result;

		result = new ModelAndView("create_edit_course/form_edit_course");
		result.addObject("curso", this.cursoService.findOne(cursoId));
		result.addObject("estilos", this.estiloService.findAll());

		List<String> niveles = new ArrayList<String>();
		for (int i = 0; i < Nivel.values().length; i++)
			niveles.add(Nivel.values()[i].name());
		result.addObject("niveles", niveles);

		List<String> dias = new ArrayList<String>();
		for (int i = 0; i < DiaSemana.values().length; i++)
			dias.add(DiaSemana.values()[i].name());
		result.addObject("dias", dias);

		return result;
	}

	//Modificar Curso

	@RequestMapping("/edit_course")
	public ModelAndView edit_course(@ModelAttribute("Curso") final Curso curso, @RequestParam("estiloId") int estiloId, @RequestParam("horaCurso") String horaCurso, final BindingResult resultado) {
		ModelAndView result;

		if (resultado.hasErrors()) {
			result = new ModelAndView("create_edit_course/form_edit_course");
			result.addObject("curso", curso);
			result.addObject("estilos", this.estiloService.findAll());

			List<String> niveles = new ArrayList<String>();
			for (int i = 0; i < Nivel.values().length; i++)
				niveles.add(Nivel.values()[i].name());
			result.addObject("niveles", niveles);

			List<String> dias = new ArrayList<String>();
			for (int i = 0; i < DiaSemana.values().length; i++)
				dias.add(DiaSemana.values()[i].name());
			result.addObject("dias", dias);
		} else {

			Estilo est = this.estiloService.findOne(estiloId);
			curso.setEstilo(est);

			try {
				Date parsedDate = CursoController.timeFormat.parse(horaCurso);
				curso.setHora(new Time(parsedDate.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			this.cursoService.save(curso);

			result = new ModelAndView("listofcourses/allcoursesofprofileacademy");

			final UserAccount user = LoginService.getPrincipal();
			result.addObject("cursos", this.cursoService.findCursosporAcademia(this.academiaService.findByAccountId(user.getId()).getId()));
			result.addObject("autoridad", user.getAuth());

		}

		return result;
	}

	//Borrar Curso

	@RequestMapping("/delete_course")
	public ModelAndView delete_course(@RequestParam(required = true) final int cursoId) {
		ModelAndView result;

		final UserAccount user = LoginService.getPrincipal();
		final Academia actual = this.academiaService.findByAccountId(user.getId());

		Curso curso = this.cursoService.findOne(cursoId);

		Iterator<Curso> iterator = actual.getCursos().iterator();
		while (iterator.hasNext()) {
			Curso c = iterator.next();
			if (c.equals(curso)) {
				iterator.remove();
				break;
			}
		}

		this.academiaService.save(actual);
		this.cursoService.delete(curso);

		result = new ModelAndView("listofcourses/allcoursesofprofileacademy");

		result.addObject("cursos", this.cursoService.findCursosporAcademia(this.academiaService.findByAccountId(user.getId()).getId()));
		result.addObject("autoridad", user.getAuth());

		return result;
	}

	// Listar todos los cursos ---------------------------------------------------------------

	@RequestMapping("/allcourses")
	public ModelAndView listofall() {

		ModelAndView result;

		result = new ModelAndView("listofcourses/allcourses");
		result.addObject("cursos", this.cursoService.findAll());

		// Verificar si el usuario está autenticado
		try {
			final UserAccount user = LoginService.getPrincipal();
			result.addObject("autoridad", user.getAuth());
		} catch (final Exception ex) {
			//No esta conectado
			result.addObject("autoridad", "nada");
		}

		return result;
	}

	// Cursos por academia ---------------------------------------------------------------

	@RequestMapping("/allcoursesfromacademy")
	public ModelAndView listbyacademy(@RequestParam(required = true) final int academiaId) {

		ModelAndView result;

		result = new ModelAndView("listofcourses/allcoursesfromacademy");
		result.addObject("cursos", this.cursoService.findCursosporAcademia(academiaId));

		// Verificar si el usuario está autenticado
		try {
			final UserAccount user = LoginService.getPrincipal();
			result.addObject("autoridad", user.getAuth());
		} catch (final Exception ex) {
			//No esta conectado
			result.addObject("autoridad", "nada");
		}

		return result;
	}

	// Cursos del usuario logueado como academia -------------------------------------------
	@RequestMapping("/coursesbyacademyprofile")
	public ModelAndView coursesofacademyprofile() {

		ModelAndView result;
		final UserAccount aux = LoginService.getPrincipal();

		if (aux.getAuth() == Authority.ACADEMIA) {
			result = new ModelAndView("listofcourses/allcoursesofprofileacademy");
			result.addObject("cursos", this.cursoService.findCursosporAcademia(this.academiaService.findByAccountId(aux.getId()).getId()));
		} else
			result = new ModelAndView("welcome/index");
		return result;
	}

	// Cursos por estilo --------------------------------------

	@RequestMapping("/allcoursesfromstyle")
	public ModelAndView listbystyle(@RequestParam(required = true) final int estiloId) {

		ModelAndView result;

		result = new ModelAndView("listofcourses/allcoursesfromstyle");
		result.addObject("cursos", this.cursoService.findCursosporEstilo(estiloId));

		// Verificar si el usuario está autenticado
		try {
			final UserAccount user = LoginService.getPrincipal();
			result.addObject("autoridad", user.getAuth());
		} catch (final Exception ex) {
			//No esta conectado
			result.addObject("autoridad", "nada");
		}

		return result;
	}

	//Cursos por filtro -------------------

	@RequestMapping("/allcoursesfromfilter")
	public ModelAndView listbyfilter(@RequestParam(required = true) final String filtro) {

		ModelAndView result;

		result = new ModelAndView("listofcourses/allcoursesfromfilter");
		result.addObject("cursos", this.cursoService.findCursosByFiltro(filtro));

		// Verificar si el usuario está autenticado
		try {
			final UserAccount user = LoginService.getPrincipal();
			result.addObject("autoridad", user.getAuth());
		} catch (final Exception ex) {
			//No esta conectado
			result.addObject("autoridad", "nada");
		}

		return result;
	}

}
