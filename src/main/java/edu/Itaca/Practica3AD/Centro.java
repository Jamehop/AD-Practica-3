package edu.Itaca.Practica3AD;

import java.util.List;

public class Centro {

	private float codigo;
	private String nombre;
	private Profesor director;
	private String direccion;
	private String localidad;
	private String provincia;
	private List<Profesor> listaProfesores;

	public Centro() {
	}

	public Centro(float codigo, String nombre, Profesor director, String direccion, String localidad, String provincia) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.director = director;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;

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

	public Profesor getDirector() {
		return director;
	}

	public void setDirector(Profesor director) {
		this.director = director;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public List<Profesor> listaProfesores() {
		return listaProfesores;
	}

	public void listadeProfesores(List<Profesor> listaProfesores) {
		this.listaProfesores = listaProfesores;
	}

	@Override
	public String toString() {
		return "Centro{" + "codigo='" + codigo + '\'' + ", nombre=" + nombre + '\'' + ", director=" + director + '\''
				+ ", direccion=" + direccion + '\'' + ", localidad=" + localidad + '\'' + ", provincia=" + provincia
				+ '\'' + ", profesores=" + listaProfesores + '}';
	}
}
