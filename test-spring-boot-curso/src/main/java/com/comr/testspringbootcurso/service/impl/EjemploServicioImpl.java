package com.comr.testspringbootcurso.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.comr.testspringbootcurso.model.Persona;
import com.comr.testspringbootcurso.service.EjemploServicio;

//en los servicios va toda la logica para no ponerla en el controller
@Service("ejemploServicio")
public class EjemploServicioImpl implements EjemploServicio{

	private static Log LOG = LogFactory.getLog(EjemploServicioImpl.class);
	
	@Override
	public List<Persona> getPersonas() {
		LOG.info("OBTENER PERSONAS EN SERVICE");
		List<Persona> pList = new ArrayList<Persona>();
		pList.add(new Persona("Omar", 29));
		pList.add(new Persona("Mariela", 28));
		pList.add(new Persona("Juan", 24));
		pList.add(new Persona("Alonso", 20));
		return pList;
	}
	
}
