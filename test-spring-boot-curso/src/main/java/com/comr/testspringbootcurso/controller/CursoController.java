package com.comr.testspringbootcurso.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.comr.testspringbootcurso.model.CursoModel;
import com.comr.testspringbootcurso.service.CursoServicio;

@Controller
@RequestMapping("/cursos")
public class CursoController {

	//log
	private static Log LOG =  LogFactory.getLog(CursoController.class);
	
	//vistas
	public static final String LIST_CURSOS_VIEW="list_cursos_view";
	public static final String CURSOS_VIEW="curso_view";
	
	//serivicios
	@Autowired
	@Qualifier("cursoServicio")
	CursoServicio cursoServicio;
	
	@GetMapping("/listcursos")
	public ModelAndView getListCursos() {
		LOG.info("#CALL listcursos: OBTENER TODOS LOS CURSOS Y PONERLOS EN LA VIEW:" + LIST_CURSOS_VIEW);
		ModelAndView mav = new ModelAndView(LIST_CURSOS_VIEW);
		mav.addObject("cursos", cursoServicio.getAllCursosList());
		return mav;
	}
	
	@GetMapping("/vercurso")
	public ModelAndView verCurso(@RequestParam(name="id",required=false,defaultValue="0") int idCurso) {	
		ModelAndView mav = new ModelAndView(CURSOS_VIEW);
		LOG.info("#CALL verCurso: VER CURSO " + idCurso);
		
		CursoModel c = new CursoModel(); 
		
		if(idCurso > 0) {
			c = cursoServicio.get(idCurso);
		}
		
		mav.addObject("curso", c);
		return mav;
	}
	
	@PostMapping("/savecurso")
	public String saveCurso(@Valid @ModelAttribute("curso") CursoModel c, BindingResult br) {		
		LOG.info("#CALL saveCurso: GUARDAR CURSO");
		if(br.hasErrors()) {
			return CURSOS_VIEW;
		}else {
			cursoServicio.save(c);
		}
		
		return "redirect:/cursos/listcursos";
	}
	
	@GetMapping("/removecurso")
	public String removeCurso(@RequestParam(name="id",required=false,defaultValue="0") int idCurso) {		
		LOG.info("#CALL removeCurso: ELIMINAR  CURSO:" + idCurso);
		cursoServicio.remove(idCurso);
		return "redirect:/cursos/listcursos";
	}
}
