package config;

import java.io.IOException;
import java.io.InputStream;
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

        try (InputStream input = DataBaseConnection.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (input == null) {
                System.out.println("No se encontró el archivo database.properties");
                return null;
            }

            // Cargar las propiedades desde el archivo
            prop.load(input);

            String url = prop.getProperty("db.url");
            String username = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");

            // Crear la conexión
            conexion = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión OK");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo de propiedades");
            e.printStackTrace();
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
