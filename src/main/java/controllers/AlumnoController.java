
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Actor;
import domain.Alumno;
import domain.Tarjeta_Credito;
import security.Authority;
import security.Credentials;
import security.LoginService;
import security.UserAccount;
import services.AcademiaService;
import services.AlumnoService;
import services.SolicitudService;
import services.Tarjeta_CreditoService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController extends AbstractController {

	@Autowired
	private AlumnoService			alumnoService;
	@Autowired
	private AcademiaService			academiaService;
	@Autowired
	private SolicitudService		solicitudService;
	@Autowired
	private LoginService			loginService;
	@Autowired
	private Tarjeta_CreditoService	tarjetaService;


	// Constructors -----------------------------------------------------------

	public AlumnoController() {
		super();
	}

	//Mostrar perfil

	@RequestMapping("/show_profile")
	public ModelAndView show_profile() {
		ModelAndView result;

		if (LoginService.haySesionIniciada() && LoginService.getPrincipal().getAuth().equals("ALUMNO")) {
			final UserAccount aux = LoginService.getPrincipal();
			result = new ModelAndView("student/student");
			result.addObject("esAlumno", true);
			result.addObject("esAcademia", false);
			result.addObject("esAdmin", false);
			result.addObject("alumno", this.alumnoService.findByAccountId(aux.getId()));

		} else
			result = new ModelAndView("welcome/index");

		return result;
	}

	// Crear alumno form ---------------------------------------------------------------

	@RequestMapping("/form_sing_up_student")
	public ModelAndView form_sing_up_student() {
		ModelAndView result;
		result = new ModelAndView("create_edit_actor/form_sing_up_student");

		result.addObject("alumno", this.alumnoService.create());

		return result;
	}

	// Crear alumno ---------------------------------------------------------------

	@RequestMapping("/sing_up_student")
	public ModelAndView sing_up_student(@ModelAttribute("alumno") final Alumno alumno, final BindingResult resultado) {
		ModelAndView result;

		if (resultado.hasErrors())
			result = new ModelAndView("create_edit_actor/form_sing_up_student");
		else {
			final UserAccount cuenta = this.loginService.create();
			cuenta.setUsername(alumno.getUserAccount().getUsername());
			UserAccount.generateMD5Hash(alumno.getUserAccount().getPassword(), cuenta);

			final Authority auth = new Authority();
			auth.setAuthority(Authority.ALUMNO);
			cuenta.addAuthority(auth);

			try {
				alumno.setUserAccount(this.loginService.save(cuenta));
			} catch (final Exception e) {
				System.err.println("Error al guardar el UserAccount: " + e.getMessage());
				result = new ModelAndView("create_edit_actor/form_sing_up_student");
			}

			try {
				Tarjeta_Credito tarjeta = this.tarjetaService.create();
				tarjeta.setMarca(alumno.getTarjetaCredito().getMarca());
				tarjeta.setAnio(alumno.getTarjetaCredito().getAnio());
				tarjeta.setCodigoCVV(alumno.getTarjetaCredito().getCodigoCVV());
				tarjeta.setMes(alumno.getTarjetaCredito().getMes());
				tarjeta.setNombreTitular(alumno.getNombre() + " " + alumno.getApellidos());
				tarjeta.setNumero(alumno.getTarjetaCredito().getNumero());
				alumno.setTarjetaCredito(this.tarjetaService.save(tarjeta));
			} catch (final Exception e) {
				System.err.println("Error al guardar la Tarjeta de Credito: " + e.getMessage());
				result = new ModelAndView("create_edit_actor/form_sing_up_student");
			}

			try {
				this.alumnoService.save(alumno);
			} catch (final Exception e) {
				System.err.println("Error al guardar el Usuario: " + e.getMessage());
				result = new ModelAndView("create_edit_actor/form_sing_up_student");
			}
			result = new ModelAndView("security/login");
			Credentials credentials = new Credentials();
			result.addObject("credentials", credentials);
		}
		return result;
	}

	//Modificar alumno form

	@RequestMapping("/form_edit_student")
	public ModelAndView form_edit_alumno() {
		ModelAndView result;

		if (LoginService.haySesionIniciada() && LoginService.getPrincipal().getAuth().equals("ALUMNO")) {
			result = new ModelAndView("create_edit_actor/form_edit_student");

			final UserAccount aux = LoginService.getPrincipal();
			result.addObject("alumno", this.alumnoService.findByAccountId(aux.getId()));
		} else
			result = new ModelAndView("welcome/index");
		return result;
	}

	//Modificar alumno

	@RequestMapping("/edit_student")
	public ModelAndView edit_student(@ModelAttribute("Alumno") final Alumno alumno, final BindingResult resultado) {
		ModelAndView result;

		if (LoginService.haySesionIniciada() && LoginService.getPrincipal().getAuth().equals("ALUMNO")) {
			if (resultado.hasErrors()) {
				result = new ModelAndView("create_edit_actor/form_edit_student");
				result.addObject("alumno", alumno);
			} else {
				final UserAccount user = LoginService.getPrincipal();
				UserAccount.generateMD5Hash(alumno.getUserAccount().getPassword(), user);
				user.setUsername(alumno.getUserAccount().getUsername());

				Alumno aux = this.alumnoService.findByAccountId(user.getId());
				aux.setApellidos(alumno.getApellidos());
				aux.setNombre(alumno.getNombre());
				aux.setCorreo(alumno.getCorreo());
				aux.setDireccionPostal(alumno.getDireccionPostal());
				aux.setTelefono(alumno.getTelefono());
				aux.setUserAccount(this.loginService.save(user));

				result = new ModelAndView("student/student");

				result.addObject("alumno", this.alumnoService.save(aux));

				result.addObject("autoridad", user.getAuth());
			}
		} else
			result = new ModelAndView("welcome/index");

		return result;
	}

	//Listar Solicitudes por Alumno

	@RequestMapping(value = "/listofapplicationbystudent")
	public ModelAndView solicitudesPorAlumno() {
		ModelAndView result;

		if (LoginService.haySesionIniciada() && LoginService.getPrincipal().getAuth().equals("ALUMNO")) {
			final UserAccount user = LoginService.getPrincipal();
			final Alumno actual = this.alumnoService.findByAccountId(user.getId());

			result = new ModelAndView("listofapplication/listofapplicationbystudent");
			result.addObject("solicitudes", this.solicitudService.findAllSolicitudesByAlumno(actual.getId()));
		} else
			result = new ModelAndView("welcome/index");
		return result;
	}

	//Mostrar suscriptores

	@RequestMapping(value = "/listofsubsbystudent")
	public ModelAndView subbystudent() {
		ModelAndView result;

		if (LoginService.haySesionIniciada() && LoginService.getPrincipal().getAuth().equals("ALUMNO")) {
			final UserAccount user = LoginService.getPrincipal();
			final Alumno actual = this.alumnoService.findByAccountId(user.getId());

			result = new ModelAndView("listofsubs/listofsubsbystudent");
			result.addObject("suscriptores", this.alumnoService.findSuscritporByAlumno(actual.getId()));
		} else
			result = new ModelAndView("welcome/index");

		return result;
	}

	//Suscribirse

	@RequestMapping("/sub_student")
	public ModelAndView sub_student(@RequestParam(required = true) final int actorId) {
		final ModelAndView result;

		if (LoginService.haySesionIniciada() && LoginService.getPrincipal().getAuth().equals("ALUMNO")) {

			final UserAccount user = LoginService.getPrincipal();
			final Alumno actual = this.alumnoService.findByAccountId(user.getId());
			Actor actor;
			if (this.academiaService.findByAccountId(actorId) != null)
				actor = this.academiaService.findByAccountId(actorId);
			else
				actor = this.alumnoService.findByAccountId(actorId);

			if (!actual.getSuscritos().contains(actor) && actual.getId() != actor.getId()) {
				actual.addSuscritos(actor);

				this.alumnoService.save(actual);

			}

			result = new ModelAndView("listofsubs/listofsubsbystudent");
			result.addObject("suscriptores", this.alumnoService.findSuscritporByAlumno(actual.getId()));
		} else
			result = new ModelAndView("welcome/index");

		return result;
	}
}
