package com.comr.testspringbootcurso.converter;

import org.springframework.stereotype.Component;

import com.comr.testspringbootcurso.entity.Curso;
import com.comr.testspringbootcurso.model.CursoModel;

@Component("cursoConverter")
public class CursoConverter {

	//Convertir el entity en un DTO para que se pueda usar en la view, es de gran importancia debido a que es una mala practica usar el entiry directamente en la view
	public CursoModel entityToModel(Curso c) {		
		return  new CursoModel(c.getCursoId(), c.getNombre(), c.getDescripcion(), c.getPrecio(), c.getHorasCurso());
	}
	
	public Curso modelToEnity(CursoModel cm) {		
		return new Curso(cm.getCursoId(), cm.getNombre(), cm.getDescripcion(), cm.getPrecio(), cm.getHorasCurso());
	}
	
}
