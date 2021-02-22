package edu.Itaca.Practica3AD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import edu.Itaca.Practica3AD.dao.AsignaturaDAO;
import edu.Itaca.Practica3AD.dao.CentroDAO;
import edu.Itaca.Practica3AD.dao.ProfesorDAO;
import utilidades.Leer;

public class Main {

	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		ODB odb = ODBFactory.open("neodatis");

		ProfesorDAO profesorDAO = new ProfesorDAO();
		CentroDAO centroDAO = new CentroDAO();
		AsignaturaDAO asignaturaDAO = new AsignaturaDAO();

		try {

			ArrayList<Centro> centros = new ArrayList<Centro>();
			ArrayList<Profesor> profesores = new ArrayList<Profesor>();
			ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
			System.out.println(
					"Elige lo que quieres hacer: \n1. Poblar base de datos\n2. Listar todos los centros\n3. Listar todos los profesores"
							+ "\n4. Listar profesores de un centro\n5. Listar todos los profesores"
							+ "de un centro cuya fecha de nacimiento sea anterior a 1993\n6. Listar todos los profesores de sexo masculino"
							+ "que impartan la asignatura de Acceso a Datos\n7. Comprobar que un profesor ya existe\n\n0. Salir");

			int opcion = Leer.pedirEnteroValidar();
			while (opcion != 0) {

				switch (opcion) {
				case 1:
					poblarBaseDatos(odb, profesorDAO, centroDAO, asignaturaDAO);
					break;
				case 2:
					centros = (ArrayList<Centro>) centroDAO.getAll(odb);
					for (Centro centro : centros) {
						System.out.println(centro);
					}
					break;
				case 3:
					profesores = (ArrayList<Profesor>) profesorDAO.getAll(odb);
					for (Profesor profesor : profesores) {
						System.out.println(profesor);
					}
					break;
				case 4:
					profesores = (ArrayList<Profesor>) profesorDAO.getAll(odb);
					System.out.println("De que centro quieres los profesores?");
					String centro=Leer.pedirCadena();
					for (Profesor profesor : profesores) {
						for(Centro centro1: centros) {
							if(centro1.getNombre().equals(centro)) {
								System.out.println(profesor);
							}
						}
					}
					break;
				case 5:
					profesores = (ArrayList<Profesor>) profesorDAO.getAll(odb);
					for (Profesor profesor : profesores) {
						String fecha = profesor.getFechaNacimiento();
						int year = Integer.parseInt(fecha.substring(6, 10));
						if (year < 1993) {
							System.out.println(profesor);
						}
					}
					break;
				case 6:
					asignaturas = (ArrayList<Asignatura>) asignaturaDAO.nombreAsignatura(odb, "Acceso a datos");
					for (Asignatura asignatura : asignaturas) {
						profesores = (ArrayList<Profesor>) asignatura.getListaProfesoresAsignatura();
						for (Profesor profesor : profesores) {
							if (profesor.getSexo().contentEquals("H")) {
								System.out.println(profesor.toString());
							}
						}
					}
					break;
				case 7:
					System.out.println("Dime el codigo del profesor");
					String dato = Leer.pedirCadena();
					float codigo = Integer.parseInt(dato);

					profesores = (ArrayList<Profesor>) profesorDAO.getCodigoProfesor(odb, codigo);
					if (profesores.isEmpty()) {
						System.out.println("El profesor no esta en la base de datos");
					} else {
						for (Profesor profesor : profesores) {
							System.out.println(profesor);
						}
					}
					break;

				default:
					System.out.println("No se ha introducido una accion determinada.");
					;
				}
				System.out.println(
						"Elige lo que quieres hacer: \n1. Poblar base de datos\n2. Listar todos los centros\n3. Listar todos los profesores"
								+ "\n4. Listar profesores de un centro\n5. Listar todos los profesores"
								+ "de un centro cuya fecha de nacimiento sea anterior a 1993\n6. Listar todos los profesores de sexo masculino"
								+ " que impartan la asignatura de Acceso a Datos\n7. Comprobar que un profesor ya existe\n\n0. Salir");
				opcion = Leer.pedirEnteroValidar();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void poblarBaseDatos(ODB odb, ProfesorDAO profesorDAO, CentroDAO centroDAO,
			AsignaturaDAO asignaturaDAO) {
		// TODO Auto-generated method stub
		Profesor profesor1 = new Profesor(1, "James", "Mor", "H", "03/07/2001", 5);
		Profesor profesor2 = new Profesor(2, "Alex", "Ramon", "H", "23/09/1992", 5);
		Profesor profesor3 = new Profesor(3, "Adrian", "Calvo", "H", "06/06/1992", 5);
		Profesor profesor4 = new Profesor(4, "Bea", "Ruiz", "M", "02/02/2002", 8);
		Profesor profesor5 = new Profesor(5, "XD", "XD", "M", "05/05/1992", 8);
		Profesor profesor6 = new Profesor(6, "Raquel", "Mart", "M", "07/07/2007", 8);

		profesorDAO.create(profesor1, odb);
		profesorDAO.create(profesor2, odb);
		profesorDAO.create(profesor3, odb);
		profesorDAO.create(profesor4, odb);
		profesorDAO.create(profesor5, odb);
		profesorDAO.create(profesor6, odb);

		ArrayList<Profesor> listaProfesores1 = new ArrayList<Profesor>();
		listaProfesores1.add(profesor1);
		listaProfesores1.add(profesor2);
		listaProfesores1.add(profesor6);
		ArrayList<Profesor> listaProfesores2 = new ArrayList<Profesor>();
		listaProfesores2.add(profesor4);
		listaProfesores2.add(profesor5);
		listaProfesores2.add(profesor3);

		Centro c1 = new Centro(1, "Itaca", profesor1, "c/San Jose", "Zaragoza", "Zaragoza");
		c1.listadeProfesores(listaProfesores1);
		centroDAO.create(c1, odb);
		Centro c2 = new Centro(2, "Santo Domingo de Silos", profesor2, "c/Victoria", "Zaragoza", "Zaragoza");
		c2.listadeProfesores(listaProfesores2);
		centroDAO.create(c2, odb);

		profesor1.setCentroProfesor(c1);
		profesor3.setCentroProfesor(c1);
		profesor6.setCentroProfesor(c1);

		profesor2.setCentroProfesor(c2);
		profesor4.setCentroProfesor(c2);
		profesor5.setCentroProfesor(c2);

		ArrayList<Profesor> profesorAD = new ArrayList<Profesor>();
		profesorAD.add(profesor1);
		profesorAD.add(profesor3);
		ArrayList<Profesor> profesorPSP = new ArrayList<Profesor>();
		profesorPSP.add(profesor2);
		profesorPSP.add(profesor4);
		ArrayList<Profesor> profesorEIE = new ArrayList<Profesor>();
		profesorEIE.add(profesor3);
		profesorEIE.add(profesor6);
		ArrayList<Profesor> profesorProgramacion = new ArrayList<Profesor>();
		profesorProgramacion.add(profesor1);
		profesorProgramacion.add(profesor3);
		ArrayList<Profesor> profesorDInterfaces = new ArrayList<Profesor>();
		profesorDInterfaces.add(profesor2);
		profesorDInterfaces.add(profesor4);
		ArrayList<Profesor> profesorIngles = new ArrayList<Profesor>();
		profesorIngles.add(profesor3);
		profesorIngles.add(profesor6);
		ArrayList<Profesor> profesorSistemas = new ArrayList<Profesor>();
		profesorSistemas.add(profesor1);
		profesorSistemas.add(profesor2);
		ArrayList<Profesor> profesorTutoria = new ArrayList<Profesor>();
		profesorTutoria.add(profesor3);
		profesorTutoria.add(profesor4);

		Asignatura asignatura1 = new Asignatura(20, "Acceso a Datos");
		asignatura1.setListaProfesoresAsignatura(profesorAD);
		Asignatura asignatura2 = new Asignatura(21, "PSP");
		asignatura2.setListaProfesoresAsignatura(profesorPSP);
		Asignatura asignatura3 = new Asignatura(22, "EIE");
		asignatura3.setListaProfesoresAsignatura(profesorEIE);
		Asignatura asignatura4 = new Asignatura(23, "Programacion");
		asignatura4.setListaProfesoresAsignatura(profesorProgramacion);
		Asignatura asignatura5 = new Asignatura(24, "Desarrollo Interfaces");
		asignatura5.setListaProfesoresAsignatura(profesorDInterfaces);
		Asignatura asignatura6 = new Asignatura(25, "Ingles");
		asignatura6.setListaProfesoresAsignatura(profesorIngles);
		Asignatura asignatura7 = new Asignatura(26, "Sistema de gestion");
		asignatura7.setListaProfesoresAsignatura(profesorSistemas);
		Asignatura asignatura8 = new Asignatura(27, "Tutoria");
		asignatura8.setListaProfesoresAsignatura(profesorTutoria);

		asignaturaDAO.create(asignatura1, odb);
		asignaturaDAO.create(asignatura2, odb);
		asignaturaDAO.create(asignatura3, odb);
		asignaturaDAO.create(asignatura4, odb);
		asignaturaDAO.create(asignatura5, odb);
		asignaturaDAO.create(asignatura6, odb);
		asignaturaDAO.create(asignatura7, odb);
		asignaturaDAO.create(asignatura8, odb);

		System.out.println("Base de datos poblada con exito!\n");
	}

}
