package edu.Itaca.Practica1AD;

import java.sql.*;
import java.util.Scanner;

public class Main {
	static Connection conn = null;
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria?serverTimezone=UTC", "admin",
					"admin");

			Statement stmt = conn.createStatement();
			/*
			 * ResultSet rs = stmt.executeQuery("select * from cliente");
			 * 
			 * while (rs.next()) { String id = rs.getString("codigo_cliente");
			 * System.out.println(id); String name = rs.getString("nombre_cliente");
			 * System.out.println(name); }
			 */
			System.out.println(
					"Elige lo que quieres hacer: \n1. Añadir cliente\n2. Mostrar cliente\n3. Mostrar todos clientes\n4. Buscar cliente\n5. Edita producto");

			int opcion = teclado.nextInt();
			switch (opcion) {
			case 1:
				añadirCliente();
			case 2:
				mostrarCliente();
			case 3:
				mostrarTodosClientes();
			case 4:
				buscarClientes();
			case 5:
				updateClientes();
			}

			conn.close();

		} catch (

		SQLException ex) {
			ex.printStackTrace();
		}

	}

	public static void añadirCliente() throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria?serverTimezone=UTC", "admin",
				"admin");

		System.out.println("Introduce los datos del cliente:");

		System.out.println("Codigo_cliente: ");
		int codigo_cliente = teclado.nextInt();
		System.out.println("Nombre_cliente: ");
		String nombre_cliente = teclado.nextLine();
		System.out.println("Telefono: ");
		String telefono = teclado.nextLine();
		System.out.println("Fax: ");
		String fax = teclado.nextLine();
		System.out.println("Linea_direccion1: ");
		String linea_direccion1 = teclado.nextLine();
		System.out.println("Ciudad: ");
		String ciudad = teclado.nextLine();
		System.out.println("Codigo_empleado_rep_ventas: ");
		int codigo_empleado_rep_ventas = teclado.nextInt();

		String sql = "INSERT INTO cliente (codigo_cliente, nombre_cliente, telefono, fax, linea_direccion1, ciudad, codigo_empleado_rep_ventas) VALUES (?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, codigo_cliente);
		statement.setString(2, nombre_cliente);
		statement.setString(3, telefono);
		statement.setString(4, fax);
		statement.setString(5, linea_direccion1);
		statement.setString(6, ciudad);
		statement.setInt(7, codigo_empleado_rep_ventas);

		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("Se ha introducido un nuevo cliente correctamente");
		}

	}

	public static void mostrarCliente() throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria?serverTimezone=UTC", "admin",
				"admin");
		System.out.println("Introduce el codigo del cliente:");
		int codigo_cliente = teclado.nextInt();
		String sql = "SELECT * FROM cliente WHERE codigo_cliente=" + codigo_cliente;

		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);

		while (result.next()) {
			String nombre_cliente = result.getString(2);
			String telefono = result.getString(3);
			String linea_direccion1 = result.getString(5);
			String ciudad = result.getString(6);

			String output = "Cliente #" + codigo_cliente + ": %s - %s - %s - %s";
			System.out.println(String.format(output, nombre_cliente, telefono, linea_direccion1, ciudad));
		}

	}

	public static void mostrarTodosClientes() throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria?serverTimezone=UTC", "admin",
				"admin");
		String sql = "SELECT * FROM cliente ORDER BY nombre_cliente ASC";

		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);

		while (result.next()) {
			String nombre_cliente = result.getString(2);
			String nombre_contacto = result.getString(3);
			String telefono = result.getString(5);
			String linea_direccion1 = result.getString(7);

			String output = "%s - %s - %s - %s";
			System.out.println(String.format(output, nombre_cliente, nombre_contacto, telefono, linea_direccion1));
		}
	}

	public static void buscarClientes() throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria?serverTimezone=UTC", "admin",
				"admin");
		System.out.println("Introduce el nombre, contacto o apellido del cliente a buscar:");
		String palabra=teclado.next();
		String sql = "SELECT * FROM cliente WHERE nombre_cliente LIKE '%"+palabra+"%' OR nombre_contacto LIKE '%"+palabra+"%' OR apellido_contacto LIKE '%"+palabra+"%'";

		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		while (result.next()) {
			String nombre_cliente = result.getString(2);
			String nombre_contacto = result.getString(3);
			String apellido_contacto = result.getString(4);

			String output = "%s - %s - %s";
			System.out.println(String.format(output, nombre_cliente, nombre_contacto, apellido_contacto));
		}
	}
	
	public static void updateClientes() throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria?serverTimezone=UTC", "admin",
				"admin");
		System.out.println("Introduce el codigo del producto:");
		int codigo=teclado.nextInt();
		String sql = "SELECT * FROM producto WHERE codigo_producto="+codigo;

		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		while (result.next()) {
			int codigo_producto = result.getInt(1);
			String nombre  = result.getString(2);
			String gama = result.getString(3);
			int cantidad_en_stock = result.getInt(7);
			long precio_venta = result.getLong(8);

			String output = "%s - %s - %s - %s - %s";
			System.out.println(String.format(output, codigo_producto, nombre , gama, cantidad_en_stock, precio_venta));
		}
		
		
	}
}
