package com.comr.testspringbootcurso.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comr.testspringbootcurso.model.Persona;

//se puede utilizar en el controller
@Component("ejemploComponent") //con este nombre lo inicializamos en el controller por medio de @Qualifier
public class EjemploComponent {

	private Log LOG = LogFactory.getLog(EjemploComponent.class);
	
	public boolean esValidaPersona(Persona p) {
		LOG.info("Validar la persona:" + p);
		if(p == null || p.getNombre() == null || p.getNombre().trim() == "" || p.getEdad() <= 0) {
			LOG.info("Persona no valida");
			return false;
		}
		return true;
	}
}
