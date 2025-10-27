package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {

	/**
	 *metodo que realiza la conexion a la base de datos
	 * 
	 * @return Connection conexion
	 */
	public static Connection connect() {
		Connection conexion = null;
		Properties prop = new Properties();
		try {
			conexion = DriverManager.getConnection(prop.getProperty("db.url"), prop.getProperty("db_username"),
					prop.getProperty("b.password"));
			System.out.println("Conexion OK");
		} catch (SQLException e) {
			System.out.println("Error en la conexion");
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
