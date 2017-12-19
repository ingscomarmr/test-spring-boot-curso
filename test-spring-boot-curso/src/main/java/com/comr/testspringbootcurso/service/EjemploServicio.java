package com.comr.testspringbootcurso.service;

import java.util.List;

import com.comr.testspringbootcurso.model.Persona;

//se debe declarar una interface para cada service en spring
public interface EjemploServicio {
	
	public abstract List<Persona> getPersonas();
}
