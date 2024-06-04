
package controllers;

import java.util.ArrayList;
import java.util.Collection;

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
import security.Authority;
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


	//Mostrar Comentario

	@RequestMapping("/show_comment")
	public ModelAndView show_academy(@RequestParam(required = true) final int comentarioId) {
		ModelAndView result;

		result = new ModelAndView("comment/comment");
		result.addObject("comentario", this.comentarioService.findOne(comentarioId));

		boolean esAlumno = false, esAcademia = false, esAdmin = false;

		// Verificar si el usuario está autenticado
		final UserAccount user = LoginService.getPrincipal();

		for (final Authority authority : user.getAuthorities())
			if (authority.getAuthority().equalsIgnoreCase("ALUMNO"))
				esAlumno = true;
			else if (authority.getAuthority().equalsIgnoreCase("ACADEMIA"))
				esAcademia = true;
			else if (authority.getAuthority().equalsIgnoreCase("ADMINISTRADOR"))
				esAdmin = true;

		result.addObject("esAlumno", esAlumno);
		result.addObject("esAcademia", esAcademia);
		result.addObject("esAdmin", esAdmin);

		return result;
	}

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

		result = new ModelAndView("listofcomment/allcomments");

		final UserAccount user = LoginService.getPrincipal();
		final Alumno alumno = this.alumnoService.findByAccountId(user.getId());

		result.addObject("comentarios", this.comentarioService.findAllComentariosByAlumno(alumno.getId()));

		return result;
	}

	//Listar Comentarios por Academia ---------------------------------------------------------------
	@RequestMapping("/show_academy_comments")
	public ModelAndView allcommentsfromacademy() {
		ModelAndView result;

		result = new ModelAndView("listofcomment/allcomments");

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

		result = new ModelAndView("welcome/index");

		if (resultado.hasErrors())
			result = new ModelAndView("create_comment/form_create_comment");
		else
			result = new ModelAndView("welcome/index");

		//FALTA AÑADIRSELO AL USUARIO
		//IGUAL QUE EL DE TUTORIALES

		this.comentarioService.save(comentario);

		return result;
	}

	//Borrar Comentario

	@RequestMapping("/delete_comment")
	public ModelAndView delete_course(@ModelAttribute("Comentario") final Comentario comentario) {
		ModelAndView result;

		result = new ModelAndView("welcome/index");

		//HAY QUE ELIMINARLO DE LA LISTA DE COMENTARIOS DEL USUARIO Y HACERLE SAVE
		//MIRAR TUTORIALES PARA HACERLO IGUAL

		this.comentarioService.delete(comentario);

		return result;
	}

}
