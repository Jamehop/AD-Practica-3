package edu.Itaca.Practica3AD;

import java.util.ArrayList;
import java.util.List;

public class Profesor {

	private float codigo;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private String sexo;
	private float centro;
	private Centro centroProfesor;
	public ArrayList<Asignatura> asignatura;

	public Profesor() {
	}

	public Profesor(float codigo, String nombre, String apellidos, String sexo, String fechaNacimiento, float centro) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.centro = centro;
	}

	public Profesor(float codigo, String nombre, String apellidos, String sexo, String fechaNacimiento, float centro,
			ArrayList<Asignatura> asignatura) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.centro = centro;
		this.asignatura = asignatura;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public float getCentro() {
		return centro;
	}

	public void setCentro(float centro) {
		this.centro = centro;
	}

	public Centro getCentroProfesor() {
		return centroProfesor;
	}

	public void setCentroProfesor(Centro centroProfesor) {
		this.centroProfesor = centroProfesor;
	}

	@Override
	public String toString() {
		return "Profesor{" + "codigo='" + codigo + '\'' + ", nombre=" + nombre + '\'' + ", apellidos=" + apellidos
				+ '\'' + ", sexo=" + sexo + '\'' + ", fechaNacimiento=" + fechaNacimiento + '\'' + ", centro=" + centro
				+ '\'' + ", asignatura=" + asignatura + ", centro=" + centroProfesor.getNombre() + '}';
	}
}
