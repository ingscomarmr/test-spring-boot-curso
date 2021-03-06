package com.comr.testspringbootcurso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="curso",schema="dbo")
public class Curso {
 
	@Id		
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="curso_id")	
	private int cursoId;
	
	@NotNull
	@Size(min=4, max=150)
	@Column(name="nombre")
	private String nombre;
	
	@NotNull
	@Size(min=4, max=300)
	@Column(name="descripcion")
	private String descripcion;
	
	@Min(1)
	@Column(name="precio")
	private double precio;
	
	@Min(1)
	@Column(name="horas_curso")
	private int horasCurso;
	
	public Curso() {}

	public Curso(int cursoId) {
		super();
		this.cursoId = cursoId;
	}
	
	public Curso(int cursoId, String nombre, String descripcion, double precio, int horasCurso) {
		super();
		this.cursoId = cursoId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.horasCurso = horasCurso;
	}
	
	public int getCursoId() {
		return cursoId;
	}
	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getHorasCurso() {
		return horasCurso;
	}
	public void setHorasCurso(int horasCurso) {
		this.horasCurso = horasCurso;
	}

	@Override
	public String toString() {		
		return "Curso [cursoId=" + cursoId + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
				+ precio + ", horasCurso=" + horasCurso + "]";
	}
	
	
	
}
 