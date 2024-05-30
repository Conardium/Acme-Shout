
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Academia;
import domain.Alumno;
import security.LoginService;
import security.UserAccount;
import services.AcademiaService;
import services.AlumnoService;
import services.SolicitudService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController extends AbstractController {

	@Autowired
	private AlumnoService		alumnoService;
	private AcademiaService		academiaService;
	private SolicitudService	solicitudService;


	// Constructors -----------------------------------------------------------

	public AlumnoController() {
		super();
	}

	//Mostrar alumno

	@RequestMapping("/show_student")
	public ModelAndView show_student(@RequestParam(required = true) final int studentId) {
		ModelAndView result;

		result = new ModelAndView("student/student");
		result.addObject("student", this.alumnoService.findOne(studentId));

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

		result = new ModelAndView("welcome/index");

		if (resultado.hasErrors())
			result = new ModelAndView("create_edit_actor/form_sing_up_student");
		else
			result = new ModelAndView("welcome/index");

		this.alumnoService.save(alumno);
		return result;
	}

	//Modificar alumno form

	@RequestMapping("/form_edit_student")
	public ModelAndView form_edit_alumno(@RequestParam(required = true) final int alumnoId) {
		ModelAndView result;

		result = new ModelAndView("create_edit_actor/form_edit_alumno");
		result.addObject("alumno", this.alumnoService.findOne(alumnoId));

		return result;
	}

	//Modificar alumno

	@RequestMapping("/edit_student")
	public ModelAndView edit_student(@ModelAttribute("Alumno") final Alumno alumno, final BindingResult resultado) {
		ModelAndView result;

		if (resultado.hasErrors())
			result = new ModelAndView("create_edit_actor/form_edit_student");
		else
			result = new ModelAndView("student/student");

		this.alumnoService.save(alumno);

		return result;
	}

	//Listar Solicitudes por Alumno

	@RequestMapping(value = "/listofapplicationbystudent")
	public ModelAndView solicitudesPorAlumno() {
		ModelAndView result;

		final UserAccount user = LoginService.getPrincipal();
		final Alumno actual = this.alumnoService.findByAccountId(user.getId());

		result = new ModelAndView("listofapplication/listofapplicationbystudent");
		result.addObject("solicitudes", this.solicitudService.findAllSolicitudesByAlumno(actual.getId()));

		return result;
	}

	//Mostrar suscriptores

	@RequestMapping(value = "/listofsubsbystudent")
	public ModelAndView subbystudent(@RequestParam(required = true) final int alumnoId) {
		ModelAndView result;

		final UserAccount user = LoginService.getPrincipal();
		final Alumno actual = this.alumnoService.findByAccountId(user.getId());

		result = new ModelAndView("listofsubs/listofsubsbystudent");
		result.addObject("suscriptores", this.alumnoService.findSuscritporByAlumno(actual.getId()));

		return result;
	}

	//Suscribirse

	@RequestMapping("/sub_student")
	public ModelAndView sub_student(@RequestParam(required = true) final int actorId) {
		final ModelAndView result;

		final UserAccount user = LoginService.getPrincipal();
		final Alumno actual = this.alumnoService.findByAccountId(user.getId());

		if (this.academiaService.findOne(actorId) != null) {
			final Academia actor = this.academiaService.findOne(actorId);
			actual.addSuscritos(actor);
		} else {
			final Alumno actor = this.alumnoService.findOne(actorId);
			actual.addSuscritos(actor);
		}

		this.alumnoService.save(actual);

		result = new ModelAndView("student/student");

		return result;
	}
}
