
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Academia;
import domain.Alumno;
import security.Authority;
import security.Credentials;
import security.LoginService;
import security.UserAccount;
import services.AcademiaService;
import services.AlumnoService;
import services.ComentarioService;
import services.SolicitudService;

@Controller
@RequestMapping("/academia")
public class AcademiaController extends AbstractController {

	@Autowired
	private AcademiaService		academiaService;
	@Autowired
	private AlumnoService		alumnoService;
	@Autowired
	private SolicitudService	solicitudService;
	@Autowired
	private LoginService		loginService;
	@Autowired
	private ComentarioService	cometarioService;


	// Constructors -----------------------------------------------------------

	public AcademiaController() {
		super();
	}

	//Mostrar perfil

	@RequestMapping("/show_profile")
	public ModelAndView show_profile() {
		ModelAndView result;

		final UserAccount aux = LoginService.getPrincipal();

		if (aux.getAuth() == Authority.ACADEMIA) {
			result = new ModelAndView("academy/academy");
			result.addObject("esAlumno", false);
			result.addObject("esAcademia", true);
			result.addObject("esAdmin", false);
		} else
			result = new ModelAndView("welcome/index");

		result.addObject("academia", this.academiaService.findByAccountId(aux.getId()));

		return result;
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
	public ModelAndView form_edit_academy() {
		ModelAndView result;

		final UserAccount aux = LoginService.getPrincipal();

		result = new ModelAndView("create_edit_actor/form_edit_academy");
		result.addObject("academia", this.academiaService.findByAccountId(aux.getId()));

		return result;
	}

	//Modificar academia

	@RequestMapping("/edit_academy")
	public ModelAndView edit_academy(@ModelAttribute("academia") final Academia academia, final BindingResult resultado) {
		ModelAndView result;

		if (resultado.hasErrors()) {
			result = new ModelAndView("create_edit_actor/form_edit_academy");
			result.addObject("academia", academia);
		} else {
			final UserAccount user = LoginService.getPrincipal();
			UserAccount.generateMD5Hash(academia.getUserAccount().getPassword(), user);
			user.setUsername(academia.getUserAccount().getUsername());

			Academia aux = this.academiaService.findByAccountId(user.getId());
			aux.setApellidos(academia.getApellidos());
			aux.setNombre(academia.getNombre());
			aux.setCorreo(academia.getCorreo());
			aux.setDireccionPostal(academia.getDireccionPostal());
			aux.setTelefono(academia.getTelefono());
			aux.setNombreComercial(academia.getNombreComercial());
			aux.setUserAccount(this.loginService.save(user));

			result = new ModelAndView("academy/academy");

			result.addObject("academia", this.academiaService.save(aux));

			result.addObject("autoridad", user.getAuth());
		}

		return result;
	}

	//Crear academia

	@RequestMapping("/sing_up_academy")
	@Transactional
	public ModelAndView sing_up_academy(@ModelAttribute("academia") final Academia academia, final BindingResult resultado) {
		ModelAndView result;

		if (resultado.hasErrors())
			result = new ModelAndView("create_edit_actor/form_sing_up_academy");
		else {

			final UserAccount cuenta = this.loginService.create();
			cuenta.setUsername(academia.getUserAccount().getUsername());
			UserAccount.generateMD5Hash(academia.getUserAccount().getPassword(), cuenta);

			final Authority auth = new Authority();
			auth.setAuthority(Authority.ACADEMIA);
			cuenta.addAuthority(auth);

			try {
				academia.setUserAccount(this.loginService.save(cuenta));
			} catch (final Exception e) {
				System.err.println("Error al guardar el UserAccount: " + e.getMessage());
				result = new ModelAndView("create_edit_actor/form_sing_up_academy");
			}

			try {
				this.academiaService.save(academia);
			} catch (final Exception e) {
				System.err.println("Error al guardar la Academia: " + e.getMessage());
				result = new ModelAndView("create_edit_actor/form_sing_up_academy");
			}
			//Te mande al login
			result = new ModelAndView("security/login");
			Credentials credentials = new Credentials();
			result.addObject("credentials", credentials);
		}
		return result;
	}

	// Todas las academias ---------------------------------------------------------------

	@RequestMapping(value = "/allacademies", method = RequestMethod.GET)
	public ModelAndView allacademies() {

		ModelAndView result;
		result = new ModelAndView("listofacademies/allacademies");

		//Verificamos si el usuario está registrado para mostrar o no los tutoriales
		if (LoginService.haySesionIniciada() == false)
			result.addObject("autoridad", "NADA");

		result.addObject("academias", this.academiaService.findAll());

		return result;
	}

	//Academia por curso

	@RequestMapping(value = "/academybycourse", method = RequestMethod.GET)
	public ModelAndView academybycourse(@RequestParam(required = true) final int cursoId) {

		ModelAndView result;

		result = new ModelAndView("academy/academybycourse");
		result.addObject("academia", this.academiaService.findAcademiaporCurso(cursoId));

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
	public ModelAndView subbyacademy() {
		ModelAndView result;

		final UserAccount user = LoginService.getPrincipal();
		final Academia actual = this.academiaService.findByAccountId(user.getId());

		result = new ModelAndView("listofsubs/listofsubsbyacademy");
		result.addObject("suscriptores", this.academiaService.findSuscritporByAcademia(actual.getId()));

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

		result = new ModelAndView("listofcomment/allcomments");
		result.addObject(this.cometarioService.findAllOrderByfechaPublicacionDesc());

		return result;
	}
}
