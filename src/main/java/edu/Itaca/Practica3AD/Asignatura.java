package edu.Itaca.Practica3AD;

import java.util.List;

public class Asignatura {

	private float codigo;
	private String nombre;
	private List<Profesor> listaProfesoresAsignatura;

	public Asignatura() {
	}

	public Asignatura(float codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public float getCodigo() {
		return codigo;
	}

	public void setCodigo(float codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Profesor> getListaProfesoresAsignatura() {
		return listaProfesoresAsignatura;
	}

	public void setListaProfesoresAsignatura(List<Profesor> listaProfesoresAsignatura) {
		this.listaProfesoresAsignatura = listaProfesoresAsignatura;
	}

	@Override
	public String toString() {
		return "Asignatura{" + "codigo='" + codigo + '\'' + ", nombre=" + nombre + '\'' +
		// ", materia=" + materia +
				'}';
	}
}
