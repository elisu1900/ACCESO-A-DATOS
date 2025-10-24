package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {

	
    
    /**
     *  METODO QUE REALIZA LA CONEXION A LA BASE DE DATOS
     * @return Connection conexion
     */
    public static Connection conectar() {
        Connection conexion = null;
        Properties prop = new Properties();
        try {
            conexion = DriverManager.getConnection(prop.getProperty("db.url"), 
            										prop.getProperty("db_username"), 
            										prop.getProperty("b.password"));
            System.out.println("Conexion OK");
        } catch (SQLException e) {
            System.out.println("Error en la conexion");
            e.printStackTrace();
        }
        
        return conexion;
    }
}
