package com.comr.testspringbootcurso.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	public static final String INSERNAL_ERROR_VIEWNAME="error/500";
	
	@ExceptionHandler(Exception.class) //captura cualquier tipo de excepción pero se puede personalizar una pagina para cada error
	public String showInternalServerError() {
		
		return INSERNAL_ERROR_VIEWNAME;
	}
}
