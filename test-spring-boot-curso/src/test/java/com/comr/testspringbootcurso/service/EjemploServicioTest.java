package com.comr.testspringbootcurso.service;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.comr.testspringbootcurso.model.Persona;
import com.comr.testspringbootcurso.service.EjemploServicio;


 
@RunWith(SpringRunner.class)
@SpringBootTest
public class EjemploServicioTest {

	@Autowired
	@Qualifier("ejemploServicio")
	EjemploServicio ejemploServicio;
	
	
	@Test
	public void ejemploServiceTest() {
		List<Persona> l = ejemploServicio.getPersonas();
		assertTrue(l.size()  > 0);
	}
}
