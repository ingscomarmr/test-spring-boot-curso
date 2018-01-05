package com.comr.testspringbootcurso.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.comr.testspringbootcurso.entity.Curso;
import com.comr.testspringbootcurso.repository.CursoJpaRepository;
import com.comr.testspringbootcurso.service.CursoServicio;


@Service("cursoServicio")
public class CursoServicioImpl implements CursoServicio{

	private static final Log LOG = LogFactory.getLog(CursoServicioImpl.class);
	
	@Autowired
	@Qualifier("cursoJpaRepository")
	CursoJpaRepository cursoJpaRepository;
	
	@Override
	public List<Curso> getAllCursosList() {
		LOG.info("OBTENER TODOS LOS CURSOS");
		return cursoJpaRepository.findAll();
	}

	@Override
	public Curso save(Curso c) {
		LOG.info("GUARDAR EL CURSO:" + (c!=null? c.toString() : "null"));
		return cursoJpaRepository.save(c);
	}

	@Override
	public void remove(int id) {
		LOG.info("ELIMINAR EL CURSO ID:" + id);
		cursoJpaRepository.delete(new Curso(id));
	}

	@Override
	public Curso get(int id) {
		LOG.info("BUSCAR EL CURSO ID:" + id);
		return cursoJpaRepository.findByCursoId(id);
	}

	@Override
	public Curso getByNombre(String nombre) {
		LOG.info("BUSCAR EL CURSO POR NOMBRE:" + nombre);
		return cursoJpaRepository.findByNombre(nombre);
	}
	

}
