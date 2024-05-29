
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Alumno;
import services.AlumnoService;
import services.SolicitudService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController extends AbstractController {

	@Autowired
	private AlumnoService		alumnoService;
	private SolicitudService	solicitudService;


	//Mostrar alumno

	@RequestMapping("/show_student")
	public ModelAndView show_student(@RequestParam(required = true) final int studentId) {
		ModelAndView result;

		result = new ModelAndView("student/student");
		result.addObject("student", this.alumnoService.findOne(studentId));

		return result;
	}

	// Constructors -----------------------------------------------------------

	public AlumnoController() {
		super();
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

	@RequestMapping(value = "/listofapplicationbyalumn")
	public ModelAndView solicitudesPorAlumno(@RequestParam(required = true) final int idAlumno) {
		ModelAndView result;

		result = new ModelAndView("listofapplication/listofapplicationbyalumn");
		result.addObject("solicitudes", this.solicitudService.findAllSolicitudesByAlumno(idAlumno));

		return result;
	}

	//Mostrar suscriptores

	@RequestMapping(value = "/listofsubsbyalumn")
	public ModelAndView subbystudent(@RequestParam(required = true) final int idAlumno) {
		ModelAndView result;

		//hace falta recoger tanto academias como alumnos para pasarlos los dos
		//aunque se puede hacer un collection de Actores;

		result = new ModelAndView("listofsubs/listofsubsbyalumn");
		//result.addObject("solicitudes", this.solicitudService.findAllSolicitudesByAlumno(idAlumno));

		return result;
	}

	//Suscribirse

	@RequestMapping("/sub_student")
	public ModelAndView sub_student(@RequestParam(required = true) final int actorId) {
		ModelAndView result;

		//hace falta comprobar si el actor es academia o alumno y luego ya añadirlo según sea.

		result = new ModelAndView("student/student");
		//result.addObject("student", this.alumnoService();Nose que poner

		return result;
	}

}
