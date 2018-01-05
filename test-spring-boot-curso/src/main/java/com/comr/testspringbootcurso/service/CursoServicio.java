package com.comr.testspringbootcurso.service;

import java.util.List;

import com.comr.testspringbootcurso.entity.Curso;

public interface CursoServicio {

	public abstract List<Curso> getAllCursosList();
	public abstract Curso save(Curso c);
	public abstract void remove(int id);
	public abstract Curso get(int id);
	public abstract Curso getByNombre(String nombre);
	
}
