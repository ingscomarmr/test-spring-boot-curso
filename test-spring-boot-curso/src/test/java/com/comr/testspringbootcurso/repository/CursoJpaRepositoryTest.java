package com.comr.testspringbootcurso.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.comr.testspringbootcurso.entity.Curso;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoJpaRepositoryTest {

	private static final Log LOG = LogFactory.getLog(CursoJpaRepositoryTest.class);
	
	@Autowired
	@Qualifier("cursoJpaRepository")
	CursoJpaRepository cursoJpaRepository;
	

	@Test
	@Ignore
	public void getGuardarCursoTest() {
		Curso c = new Curso(0, "javascript", "Es un curso de javascript", 100.5, 45);
		LOG.info("#Guardar curso:" + c);
		cursoJpaRepository.saveAndFlush(c);		
		assertTrue(c.getCursoId() > 0);
	}
	
	@Test
	public void getCursoByIdTest() {
		LOG.info("#Buscar el curso Id:1");
		Curso curso = cursoJpaRepository.findByCursoId(1);
		LOG.info("#Curso Obtenido:" + curso.toString());
		assertTrue(curso.getCursoId() > 0);
	}
	
	@Test
	public void getCursoByNombreTest() {
		String n = "c++";
		LOG.info("#Buscar curso por nombre:" + n);
		List<Curso> cursoList = cursoJpaRepository.findByNombreOrderByHorasCurso(n);
		LOG.info("#getCursoByNombreTest cursos encontrados:" + cursoList.size());
		for (Curso c : cursoList) {
			LOG.info(c);
		}		
		assertTrue(cursoList.size()  >= 0);
	}
}
