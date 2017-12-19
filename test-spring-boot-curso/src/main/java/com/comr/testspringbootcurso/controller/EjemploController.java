package com.comr.testspringbootcurso.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.comr.testspringbootcurso.component.EjemploComponent;
import com.comr.testspringbootcurso.model.Persona;
import com.comr.testspringbootcurso.service.EjemploServicio;

@Controller
@RequestMapping("/test_controller")
public class EjemploController {

	//para logs
	private static Log LOG =  LogFactory.getLog(EjemploController.class);
	
	//nombres de las view
	public static final String INDEX_VIEW_NAME="index";
	public static final String EJEMPLO_VIEW_NAME="ejemplo1";
	public static final String VIEW_CON_PARAM_VIEW_NAME="view_con_parametro";
	public static final String VIEW_CON_OBJECT_VIEW_NAME="view_con_object";
	public static final String VIEW_CON_COLLECTION_VIEW_NAME="view_con_collections";
	public static final String VIEW_TEST_REQUEST_VIEW_NAME="view_test_request";
	public static final String FORM_PERSONA_VIEW_NAME="form_persona";
	
	
	//en los service va toda la logica para no ponerla en el controller
	@Autowired
	@Qualifier("ejemploServicio")
	private EjemploServicio ejpServicio;
	
	//para usar y mandar a llamar componentes de apoyo
	@Autowired
	@Qualifier("ejemploComponent")
	private EjemploComponent ejpComponent; //ya no necesita que lo inicialicemos nosotros
	
	@GetMapping("/")
	public String getIndex() {
		//return "redirect:/test_controller/agregar_persona"; //redirecciona a un action
		return INDEX_VIEW_NAME;
		
	}
	
	//esta es una forma de retornar la forma si no necesitas hacer la gran cosa con la view 
	@GetMapping("/view_simple1")
	public String getViewEjemplo1() {
		return EJEMPLO_VIEW_NAME;
	}
	
	//esta es otra forma mas compleja para view que requieren de muchos datos que se introducen desde el model
	@GetMapping("/view_simple2")
	public ModelAndView getViewMaVEjemplo1() {
		ModelAndView mav = new ModelAndView(EJEMPLO_VIEW_NAME);
		return mav;
	}
	
	//incrustar parametros en la view
	@GetMapping("/view_enviar_param")
	public String setModelEjp2(Model m) {
		m.addAttribute("nombre", "Omar Munguia R.");
		return VIEW_CON_PARAM_VIEW_NAME;
	}
	
	//incrustar parametros en la view
	@GetMapping("/view_enviar_param2")
	public ModelAndView setModelAndViewEjp2() {
		ModelAndView mav = new ModelAndView(VIEW_CON_PARAM_VIEW_NAME);
		mav.addObject("nombre", "Luis Pablo Munguia P.");
		return mav;
	}
	
	//incrustar un objeto en la view
	@GetMapping("/view_enviar_bject")
	public String setObjectModelEjp2(Model m) {
		m.addAttribute("persona", new Persona("Omar Munguia",29));
		return VIEW_CON_OBJECT_VIEW_NAME;
	}
	
	//incrustar un objeto en la view
	@GetMapping("/view_enviar_object2")
	public ModelAndView setObjectModelAndViewEjp2() {
		ModelAndView mav = new ModelAndView(VIEW_CON_OBJECT_VIEW_NAME);
		mav.addObject("persona", new Persona("Luis Pablo Munguia P.",6));
		return mav;
	}
			
	//incrustar un collections en la view
	@GetMapping("/view_enviar_list")
	public String setCollectionModelEjp2(Model m) {
		m.addAttribute("personas", ejpServicio.getPersonas());
		return VIEW_CON_COLLECTION_VIEW_NAME;
	}
	
	//incrustar una collection en la view
	@GetMapping("/view_enviar_list2")
	public ModelAndView setCollectionModelAndViewEjp2() {
		ModelAndView mav = new ModelAndView(VIEW_CON_COLLECTION_VIEW_NAME);
		mav.addObject("personas", ejpServicio.getPersonas());
		return mav;
	}
	
	//recivir un parametro por medio de get
	//localhost:8080/test_controller/view_solicitar_param?nm=Omar
	//localhost:8080/test_controller/view_solicitar_param?nm=Nadia
	@GetMapping("/view_solicitar_param")
	public ModelAndView requestParamAndSend(@RequestParam(name="nm",required=false,defaultValue="SIN NOMBRE") String nameParam) {
		ModelAndView mav = new ModelAndView(VIEW_TEST_REQUEST_VIEW_NAME);
		mav.addObject("name_in_model", nameParam);
		return mav;
	}
	
	//recivir un parametro por medio de get
	//localhost:8080/test_controller/view_solicitar_param/Omar
	//localhost:8080/test_controller/view_solicitar_param/Nadia
	@GetMapping("/view_solicitar_param2/{nm}")
	public ModelAndView requestParamAndSend2(@PathVariable(name="nm",required=false) String nameParam) {
		ModelAndView mav = new ModelAndView(VIEW_TEST_REQUEST_VIEW_NAME);
		mav.addObject("name_in_model", nameParam);
		return mav;
	}
	
	//insertar un model a un formulario
	@GetMapping("/agregar_persona")
	public String showFormAddPersona(Model m) {
		m.addAttribute("persona", new Persona());
		return FORM_PERSONA_VIEW_NAME;
	}
	
	//recivir parametros por medio de un model y reenviarlos a otro view
	@PostMapping("/registrar_persona")
	public ModelAndView addPersona(@ModelAttribute("persona") Persona persona) throws Exception {
		if(!ejpComponent.esValidaPersona(persona)) {
			throw new Exception("Persona no valida");
		}
		ModelAndView mav = new ModelAndView(VIEW_CON_OBJECT_VIEW_NAME);
		mav.addObject("persona", persona);
		LOG.info("alta de persona View:" + VIEW_CON_OBJECT_VIEW_NAME + ", PARAMETROS:" + persona);
		return mav;
	}
	
	@PostMapping("/test_internal_error")
	public ModelAndView showInternalError() {
		ModelAndView mav = new ModelAndView(VIEW_CON_OBJECT_VIEW_NAME);
		LOG.info("Provocar una excepcion a propocito para que sea tratada por ExceptionController");
		int i = 10 /0;
		return mav;
	}
}
