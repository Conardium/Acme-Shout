
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
import services.AcademiaService;

@Controller
@RequestMapping("/academia")
public class AcademiaController extends AbstractController {

	@Autowired
	private AcademiaService academiaService;


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

		return result;
	}

	//Academia por curso

	@RequestMapping(value = "/academybycourse", method = RequestMethod.GET)
	public ModelAndView academybycourse(@RequestParam(required = true) final int cursoId) {

		ModelAndView result;

		result = new ModelAndView("academia/academybycourse");
		result.addObject("academia", this.academiaService.findAcademiaporCurso(cursoId));

		return result;
	}

	//Mostrar suscriptores

	@RequestMapping(value = "/listofsubsbyalumn")
	public ModelAndView subbystudent(@RequestParam(required = true) final int idAlumno) {
		ModelAndView result;

		//hace falta recoger tanto academias como alumnos para pasarlos los dos
		//aunque se puede hacer un collection de Actores;

		result = new ModelAndView("listofsubs/listofsubsbyalumn");
		result.addObject("solicitudes", this.solicitudService.findAllSolicitudesByAlumno(idAlumno));

		return result;
	}

	//Suscribirse

	@RequestMapping("/sub_student")
	public ModelAndView sub_academy(@RequestParam(required = true) final int actorId) {
		ModelAndView result;

		//hace falta comprobar si el actor es academia o alumno y luego ya añadirlo según sea.

		result = new ModelAndView("academy/academy");
		//result.addObject("student", this.alumnoService();Nose que poner

		return result;
	}
}
