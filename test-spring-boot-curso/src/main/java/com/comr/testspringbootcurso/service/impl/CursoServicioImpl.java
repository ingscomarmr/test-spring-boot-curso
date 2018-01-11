package com.comr.testspringbootcurso.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.comr.testspringbootcurso.converter.CursoConverter;
import com.comr.testspringbootcurso.entity.Curso;
import com.comr.testspringbootcurso.model.CursoModel;
import com.comr.testspringbootcurso.repository.CursoJpaRepository;
import com.comr.testspringbootcurso.service.CursoServicio;


@Service("cursoServicio")
public class CursoServicioImpl implements CursoServicio{

	private static final Log LOG = LogFactory.getLog(CursoServicioImpl.class);
	
	@Autowired
	@Qualifier("cursoJpaRepository")
	CursoJpaRepository cursoJpaRepository;
	
	@Autowired
	@Qualifier("cursoConverter")
	CursoConverter cursoConverter;
	
	@Override
	public List<CursoModel> getAllCursosList() {
		LOG.info("OBTENER TODOS LOS CURSOS");
		List<Curso> cList = cursoJpaRepository.findAll(); 
		List<CursoModel> cmList= new ArrayList<CursoModel>();
		for (Curso curso : cList) {
			cmList.add(cursoConverter.entityToModel(curso));
		}
		return cmList;
	}

	@Override
	public CursoModel save(CursoModel cm) {
		LOG.info("GUARDAR EL CURSO:" + (cm!=null? cm.toString() : "null"));
		Curso curso = cursoConverter.modelToEnity(cm);
		curso = cursoJpaRepository.save(curso);
		return cursoConverter.entityToModel(curso);
	}

	@Override
	public void remove(int id) {
		LOG.info("ELIMINAR EL CURSO ID:" + id);
		cursoJpaRepository.delete(new Curso(id));
	}

	@Override
	public CursoModel get(int id) {
		LOG.info("BUSCAR EL CURSO ID:" + id);
		CursoModel cm = cursoConverter.entityToModel(cursoJpaRepository.findByCursoId(id));
		return cm;
	}

	@Override
	public CursoModel getByNombre(String nombre) {
		LOG.info("BUSCAR EL CURSO POR NOMBRE:" + nombre);
		return cursoConverter.entityToModel(cursoJpaRepository.findByNombre(nombre));
				
	}
	

}
