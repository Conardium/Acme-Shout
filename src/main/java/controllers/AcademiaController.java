
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Academia;
import domain.Alumno;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import services.AcademiaService;
import services.AlumnoService;
import services.SolicitudService;

@Controller
@RequestMapping("/academia")
public class AcademiaController extends AbstractController {

	@Autowired
	private AcademiaService		academiaService;
	private SolicitudService	solicitudService;
	private AlumnoService		alumnoService;


	// Constructors -----------------------------------------------------------

	public AcademiaController() {
		super();
	}

	//Mostrar academia

	@RequestMapping("/show_academy")
	public ModelAndView show_academy(@RequestParam(required = true) final int academiaId) {
		ModelAndView result;

		result = new ModelAndView("academy/academy");
		result.addObject("academia", this.academiaService.findOne(academiaId));

		return result;
	}

	//Crear academia form

	@RequestMapping("/form_sing_up_academy")
	public ModelAndView form_sing_up_academy() {
		ModelAndView result;

		result = new ModelAndView("create_edit_actor/form_sing_up_academy");
		result.addObject("academia", this.academiaService.create());

		return result;
	}

	//Modificar academia form

	@RequestMapping("/form_edit_academy")
	public ModelAndView form_edit_academy(@RequestParam(required = true) final int academiaId) {
		ModelAndView result;

		result = new ModelAndView("create_edit_actor/form_edit_academy");
		result.addObject("academia", this.academiaService.findOne(academiaId));

		return result;
	}

	//Crear academia

	@RequestMapping("/sing_up_academy")
	public ModelAndView sing_up_academy(@ModelAttribute("academia") final Academia academia, final BindingResult resultado) {
		ModelAndView result;

		if (resultado.hasErrors())
			result = new ModelAndView("create_edit_actor/form_sing_up_academy");
		else
			result = new ModelAndView("welcome/index");

		this.academiaService.save(academia);

		return result;
	}

	//Modificar academia

	@RequestMapping("/edit_academy")
	public ModelAndView edit_academy(@ModelAttribute("academia") final Academia academia, final BindingResult resultado) {
		ModelAndView result;

		if (resultado.hasErrors())
			result = new ModelAndView("create_edit_actor/form_edit_academy");
		else
			result = new ModelAndView("academy/academy");

		this.academiaService.save(academia);

		return result;
	}

	// Todas las academias ---------------------------------------------------------------

	@RequestMapping(value = "/allacademies", method = RequestMethod.GET)
	public ModelAndView allacademies() {

		ModelAndView result;

		result = new ModelAndView("listofacademies/allacademies");
		result.addObject("academias", this.academiaService.findAll());

		boolean esAlumno = false, esAcademia = false, esAdmin = false;

		// Verificar si el usuario está autenticado
		try {

			final UserAccount user = LoginService.getPrincipal();

			for (final Authority authority : user.getAuthorities())
				if (authority.getAuthority().equalsIgnoreCase("ALUMNO"))
					esAlumno = true;
				else if (authority.getAuthority().equalsIgnoreCase("ACADEMIA"))
					esAcademia = true;
				else if (authority.getAuthority().equalsIgnoreCase("ADMINISTRADOR"))
					esAdmin = true;

		} catch (final Exception ex) {
			//No esta conectado
		}

		result.addObject("esAlumno", esAlumno);
		result.addObject("esAcademia", esAcademia);
		result.addObject("esAdmin", esAdmin);

		return result;
	}

	//Academia por curso

	@RequestMapping(value = "/academybycourse", method = RequestMethod.GET)
	public ModelAndView academybycourse(@RequestParam(required = true) final int cursoId) {

		ModelAndView result;

		result = new ModelAndView("academy/academybycourse");
		result.addObject("academia", this.academiaService.findAcademiaporCurso(cursoId));

		boolean esAlumno = false, esAcademia = false, esAdmin = false;

		// Verificar si el usuario está autenticado
		try {

			final UserAccount user = LoginService.getPrincipal();

			for (final Authority authority : user.getAuthorities())
				if (authority.getAuthority().equalsIgnoreCase("ALUMNO"))
					esAlumno = true;
				else if (authority.getAuthority().equalsIgnoreCase("ACADEMIA"))
					esAcademia = true;
				else if (authority.getAuthority().equalsIgnoreCase("ADMINISTRADOR"))
					esAdmin = true;

		} catch (final Exception ex) {
			//No esta conectado
		}

		result.addObject("esAlumno", esAlumno);
		result.addObject("esAcademia", esAcademia);
		result.addObject("esAdmin", esAdmin);

		return result;
	}

	//Listar Solicitudes por Academia

	@RequestMapping(value = "/listofapplicationbyacademy")
	public ModelAndView solicitudesPorAlumno() {
		ModelAndView result;

		final UserAccount user = LoginService.getPrincipal();
		final Academia actual = this.academiaService.findByAccountId(user.getId());

		result = new ModelAndView("listofapplication/listofapplicationbyacademy");
		result.addObject("solicitudes", this.solicitudService.findAllSolicitudesByAcademia(actual.getId()));

		return result;
	}

	//Mostrar suscriptores

	@RequestMapping(value = "/listofsubsbyacademy")
	public ModelAndView subbystudent() {
		ModelAndView result;

		final UserAccount user = LoginService.getPrincipal();
		final Academia actual = this.academiaService.findByAccountId(user.getId());

		result = new ModelAndView("listofsubs/listofsubsbyacademy");
		result.addObject("suscriptores", this.solicitudService.findAllSolicitudesByAcademia(actual.getId()));

		return result;
	}

	//Suscribirse

	@RequestMapping("/sub_academy")
	public ModelAndView sub_academy(@RequestParam(required = true) final int actorId) {
		ModelAndView result;

		final UserAccount user = LoginService.getPrincipal();
		final Academia actual = this.academiaService.findByAccountId(user.getId());

		if (this.academiaService.findOne(actorId) != null) {
			final Academia actor = this.academiaService.findOne(actorId);
			actual.addSuscritos(actor);
		} else {
			final Alumno actor = this.alumnoService.findOne(actorId);
			actual.addSuscritos(actor);
		}

		this.academiaService.save(actual);

		result = new ModelAndView("academy/academy");

		return result;
	}
}
