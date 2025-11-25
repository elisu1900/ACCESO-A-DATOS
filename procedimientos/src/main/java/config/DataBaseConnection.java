package config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

	public static final String URL = "jdbc:mysql://localhost:3306/tarea4_jdbc?serverTimezone=UTC";
	public static final String USER = "root";
	public static final String PASSWORD = "root";

	/**
	 * metodo que realiza la conexion a la base de datos
	 * 
	 * @return Connection conexion
	 */
	public static Connection connect() {
		Connection conexion = null;

		try {

			conexion = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conexión OK");

		} catch (SQLException e) {
			System.out.println("Error en la conexión a la base de datos");
			e.printStackTrace();
		}

		return conexion;
	}

	/**
	 * metodo para cerrar la conexion
	 * 
	 * @param conexion Connection a cerrar
	 */
	public static void desconnect(Connection conexion) {
		if (conexion != null) {
			try {
				conexion.close();
				System.out.println("Conexion cerrada");
			} catch (SQLException e) {
				System.out.println("Error al cerrar la conexion");
				e.printStackTrace();
			}
		}
	}
}
