package com.comr.testspringbootcurso.service;

import java.util.List;

import com.comr.testspringbootcurso.entity.Curso;
import com.comr.testspringbootcurso.model.CursoModel;

public interface CursoServicio {

	public abstract List<CursoModel> getAllCursosList();
	public abstract CursoModel save(CursoModel c);
	public abstract void remove(int id);
	public abstract CursoModel get(int id);
	public abstract CursoModel getByNombre(String nombre);
	
}
