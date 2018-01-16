package com.comr.testspringbootcurso.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

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
public class CursoQueryDSLRepositoryTest {

private static final Log LOG = LogFactory.getLog(CursoQueryDSLRepositoryTest.class);
	
	@Autowired
	@Qualifier("cursoQuerysDSLRepository")
	CursoQuerysDSLRepository cursoQuerysDSLRepository;
	
	@Ignore
	@Test
	public void testQueryByNombreContain() {
		LOG.info("BUSCAR TODOS LOS CURSOS CON and");
		List<Curso> cList = cursoQuerysDSLRepository.findCursosByNombreContaint("and");
		
		for (Curso curso : cList) {
			LOG.info("#CURSO ENCONTRADO:" + curso);
		}
		assertTrue(cList.size() > 0);
		
	}
	
	@Ignore
	@Test
	public void testQueryByPrecioAndNombreContain() {
		String nombre = "and";
		double precio = 19;
		
		LOG.info("BUSCAR TODOS LOS CURSOS QUE CONTENGAN:" + nombre + " Y PRECIO MENOR O IGUAL A:" + precio);
		List<Curso> cList = cursoQuerysDSLRepository.findCursosByPrecioAndNombreContain(precio, nombre);
		
		for (Curso curso : cList) {
			LOG.info("#CURSO ENCONTRADO:" + curso);
		}
		assertTrue(cList.size() > 0);
		
	}
	
	@Test
	public void testQueryByNombreHorasPrecio() {
		String nombre = "andro";
		int horas = 20;
		double precio = 0;
		
		LOG.info("BUSCAR TODOS LOS CURSOS QUE CONTENGAN:" + nombre + " Y PRECIO IGUAL A:" + precio + " Y HORAS IGUAL A:" + horas);
		List<Curso> cList = cursoQuerysDSLRepository.findCursosByNombreHorasPrecio(nombre, horas, precio);
		
		for (Curso curso : cList) {
			LOG.info("#CURSO ENCONTRADO:" + curso);
		}
		
		assertTrue(cList.size() > 0);
		
	}
}
