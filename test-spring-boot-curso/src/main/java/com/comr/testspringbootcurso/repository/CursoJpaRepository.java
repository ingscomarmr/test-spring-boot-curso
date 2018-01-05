package com.comr.testspringbootcurso.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.comr.testspringbootcurso.entity.Curso;


//una vez realizado esto no se necesita una calse que implementa ya que spring lo implementa en automatico

@Repository("cursoJpaRepository")
public interface CursoJpaRepository extends JpaRepository<Curso, Serializable>{
	
	//pudes declarar matodos que con la palabra clave findBy mas los nombres de las columnas los implementa por si solo spring
	public abstract List<Curso> findByNombreOrderByHorasCurso(String nombre);
	
	public abstract Curso findByNombre(String nombre);
	
	//busca el curso por id
	public abstract Curso findByCursoId(int cursoId);
	
	//busca los cursos por horas de curso y los ordena por precio
	public abstract List<Curso> findByHorasCursoOrderByPrecio(int horasCurso);
	
}
