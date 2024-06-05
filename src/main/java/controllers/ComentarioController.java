
package controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Academia;
import domain.Actor;
import domain.Alumno;
import domain.Comentario;
import security.LoginService;
import security.UserAccount;
import services.AcademiaService;
import services.AlumnoService;
import services.ComentarioService;

@Controller
@RequestMapping("/comentario")
public class ComentarioController {

	@Autowired
	private ComentarioService	comentarioService;
	@Autowired
	private AlumnoService		alumnoService;
	@Autowired
	private AcademiaService		academiaService;


	// Listar todos los comentarios ---------------------------------------------------------------

	@RequestMapping("/allcomments")
	public ModelAndView listofall() {

		ModelAndView result;

		result = new ModelAndView("listofcomment/allcomments");

		Collection<Comentario> comentarios = this.comentarioService.findAll();
		result.addObject("comentarios", comentarios);
		ArrayList<String> estaSuscrito = new ArrayList<String>();

		final UserAccount user = LoginService.getPrincipal();
		Actor actor;
		boolean esta;

		if (this.academiaService.findByAccountId(user.getId()) != null)
			actor = this.academiaService.findByAccountId(user.getId());
		else
			actor = this.alumnoService.findByAccountId(user.getId());

		for (Comentario comentario : comentarios) {
			esta = false;
			for (Actor suscrito : actor.getSuscritos())
				if (comentario.getActor().getId() == suscrito.getId()) {
					esta = true;
					break;
				}
			if (esta)
				estaSuscrito.add("Si");
			else
				estaSuscrito.add("No");
		}

		result.addObject("estaSuscrito", estaSuscrito);
		result.addObject("nombre", user.getUsername());
		result.addObject("autoridad", user.getAuth());

		return result;
	}

	//Listar Comentarios por Alumno ---------------------------------------------------------------
	@RequestMapping("/show_student_comments")
	public ModelAndView allcommentsfromstudent() {
		ModelAndView result;

		result = new ModelAndView("listofcomment/commentsbyuser");

		final UserAccount user = LoginService.getPrincipal();
		final Alumno alumno = this.alumnoService.findByAccountId(user.getId());

		result.addObject("comentarios", this.comentarioService.findAllComentariosByAlumno(alumno.getId()));

		return result;
	}

	//Listar Comentarios por Academia ---------------------------------------------------------------
	@RequestMapping("/show_academy_comments")
	public ModelAndView allcommentsfromacademy() {
		ModelAndView result;

		result = new ModelAndView("listofcomment/commentsbyuser");

		final UserAccount user = LoginService.getPrincipal();
		final Academia academia = this.academiaService.findByAccountId(user.getId());

		result.addObject("comentarios", this.comentarioService.findAllComentariosByAcademia(academia.getId()));

		return result;
	}

	// Crear Comentario form ---------------------------------------------------------------

	@RequestMapping("/form_create_comment")
	public ModelAndView form_create_comment() {
		ModelAndView result;

		result = new ModelAndView("create_comment/form_create_comment");
		result.addObject("comentario", this.comentarioService.create());

		return result;
	}

	// Crear Comentario ---------------------------------------------------------------

	@RequestMapping("/create_comment")
	public ModelAndView sing_up_course(@ModelAttribute("Comentario") final Comentario comentario, final BindingResult resultado) {
		ModelAndView result;

		if (resultado.hasErrors())
			result = new ModelAndView("create_comment/form_create_comment");
		else {
			result = new ModelAndView("listofcomment/commentsbyuser");

			final UserAccount user = LoginService.getPrincipal();
			Actor actor;
			comentario.setFechaPublicacion(new Date());

			if (this.academiaService.findByAccountId(user.getId()) != null) {
				actor = this.academiaService.findByAccountId(user.getId());
				comentario.setActor(actor);
				actor.getComentarios().add(this.comentarioService.save(comentario));
				this.academiaService.save((Academia) actor);
			} else {
				actor = this.alumnoService.findByAccountId(user.getId());
				comentario.setActor(actor);
				actor.getComentarios().add(this.comentarioService.save(comentario));
				this.alumnoService.save((Alumno) actor);
			}

			result.addObject("comentarios", actor.getComentarios());

		}
		return result;
	}

	//Borrar Comentario

	@RequestMapping("/delete_comment")
	public ModelAndView delete_course(@RequestParam(required = true) final int comentarioId) {
		ModelAndView result;

		result = new ModelAndView("listofcomment/commentsbyuser");

		final UserAccount user = LoginService.getPrincipal();
		Actor actor;
		Collection<Comentario> comentarios;

		if (this.academiaService.findByAccountId(user.getId()) != null) {
			actor = this.academiaService.findByAccountId(user.getId());
			comentarios = actor.getComentarios();
			for (Comentario comentario : comentarios)
				if (comentario.getId() == comentarioId) {
					this.comentarioService.delete(comentario);
					comentarios.remove(comentario);
					break;
				}
			actor.setComentarios(comentarios);
			this.academiaService.save((Academia) actor);
		} else {
			actor = this.alumnoService.findByAccountId(user.getId());
			comentarios = actor.getComentarios();
			for (Comentario comentario : comentarios)
				if (comentario.getId() == comentarioId) {
					this.comentarioService.delete(comentario);
					comentarios.remove(comentario);
					break;
				}
			actor.setComentarios(comentarios);
			this.alumnoService.save((Alumno) actor);
		}

		result.addObject("comentarios", actor.getComentarios());

		return result;
	}

}
