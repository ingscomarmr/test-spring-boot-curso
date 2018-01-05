package com.comr.testspringbootcurso.service;

import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Incubating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.comr.testspringbootcurso.entity.Curso;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoServicioTest {
	 
	private static final Log LOG = LogFactory.getLog(CursoServicioTest.class);
	
	@Autowired
	@Qualifier("cursoServicio")
	CursoServicio cursoServicio;
	
	private static final String NAME_CURSO="php test";
	
	
	@Test
	@Rollback(value=false)
	public void guardarCurso() {
		LOG.info("# Guardar el curso php test");
		Curso c = cursoServicio.getByNombre("php test");
		
		if(c == null || c.getCursoId() <= 0) {
			c = new Curso(0,"php test","Curso de php",120,10);			
		}else {
			c.setHorasCurso(c.getHorasCurso() + 1);
		}
		
		LOG.info("#Guardar curso:" + c);
		c = cursoServicio.save(c);
		
		LOG.info("#Curso guardado:" + c);		
		assertTrue(c.getCursoId() > 0);
	}
	
	@Ignore
	@Test		
	public void buscarCurso() {
		Curso c = cursoServicio.getByNombre(NAME_CURSO);
		LOG.info("#Curso encontrado por nombre:" + c);						
		assertTrue(c.getCursoId() > 0);
	}
	
	@Ignore
	@Test	
	@Rollback(value=false)
	public void deleteCurso() {
		Curso c = cursoServicio.getByNombre(NAME_CURSO);
		LOG.info("#Curso encontrado por nombre:" + c);
		if(c != null && c.getCursoId() > 0) {
			cursoServicio.remove(c.getCursoId());			
		}
		assertTrue(true);	
	}
}
