package com.comr.testspringbootcurso.repository;

import java.awt.geom.QuadCurve2D;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.comr.testspringbootcurso.entity.Curso;
import com.comr.testspringbootcurso.entity.QCurso;
import com.querydsl.jpa.impl.JPAQuery;

//este elemento se utiliza cuando se desea realizar querys complejos que JpaRepository se vuelve dificil de usar
@Repository("cursoQuerysDSLRepository")
public class CursoQuerysDSLRepository {
	
	//para realizar el query dsl indicamos de calse es
	private QCurso qCurso = QCurso.curso;
	
	//toma el entitymanager que esta en el contexto para no generar otra
	@PersistenceContext
	private EntityManager em;
	
	//Query utilizado para buscar cursos que contenga en el nombre alfunos caracteres
	public List<Curso> findCursosByNombreContaint(String nombre) {
		JPAQuery<Curso> cursoQuery = new JPAQuery<Curso>(em);
		return cursoQuery.select(qCurso)
				.from(qCurso)
				.where(qCurso.nombre.contains(nombre))
				.orderBy(qCurso.nombre.desc())
				.fetch();
	}
	
	//Query utilizado para buscar cursos que sea menos o igual al precio que tengo y que inicie con el nombre
	public List<Curso> findCursosByPrecioAndNombreContain(double precio, String nombre) {
		JPAQuery<Curso> cursoQuery = new JPAQuery<Curso>(em);
		return cursoQuery.select(qCurso)
				.from(qCurso)
				.where(qCurso.nombre.contains(nombre),qCurso.precio.loe(precio))
				.orderBy(qCurso.nombre.asc(), qCurso.precio.asc())
				.fetch();
	}
	
}
