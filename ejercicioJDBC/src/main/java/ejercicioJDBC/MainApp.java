package ejercicioJDBC;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainApp {

    public static void main(String[] args) {

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("clientes.txt"));
             Connection conexion = Conexion.conectar();
             Statement instruccion = conexion.createStatement()) {

            String query = "SELECT Id, empresa, contacto FROM clientes";
            ResultSet resultados = instruccion.executeQuery(query);

            System.out.println("Listado de clientes:");
            while (resultados.next()) {
                String linea = "Cliente " + resultados.getString("Id")
                        + ", empresa: " + resultados.getString("empresa")
                        + ", Teléfono: " + resultados.getString("contacto");
                escritor.write(linea);
                escritor.newLine();
                System.out.println(linea);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
