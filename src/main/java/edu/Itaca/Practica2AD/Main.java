package edu.Itaca.Practica2AD;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import edu.Itaca.Practica2AD.dao.AsignaturaDAO;
import edu.Itaca.Practica2AD.dao.CentroDAO;
import edu.Itaca.Practica2AD.dao.ProfesorDAO;
import utilidades.Leer;

public class Main {
	
	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		ODB odb = ODBFactory.open("Escritorio\\ADPRUEBANEODATIS.DB"); //Se crea la base de datos
		
		ProfesorDAO profesorDAO = new ProfesorDAO();   
    	CentroDAO centroDAO = new CentroDAO();
    	AsignaturaDAO asignaturaDAO = new AsignaturaDAO();

		try {
			

			System.out.println(
					"Elige lo que quieres hacer: \n1. Poblar base de datos\n2. Listar todos los centros\n3. Listar todos los profesores"
					+ "\n4. Listar profesores de un centro\n5. Listar todos los profesores"
					+ "de un centro cuya fecha de nacimiento sea anterior a 1993\n6. Listar todos los profesores de sexo masculino"
					+ "que impartan la asignatura de Acceso a Datos\n\n0. Salir");

			int opcion = Leer.pedirEnteroValidar();
			while (opcion != 0) {

				switch (opcion) {
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				case 5:
					
					break;
				case 6:
					
					break;
				default:
					System.out.println("No se ha introducido una accion determinada.");
					;
				}
				System.out.println(
						"Elige lo que quieres hacer: \n1. Añadir cliente\n2. Mostrar cliente\n3. Mostrar todos clientes"
						+ "\n4. Buscar cliente\n5. Edita producto\n6. Muestra todos los detalles de los pedidos de un Cliente\n0. Salir");
				opcion = Leer.pedirEnteroValidar();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
