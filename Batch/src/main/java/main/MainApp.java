package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import config.DataBaseConnection;
import model.Empresa;

public class MainApp {

	public static final String SQL = "INSERT proveedores(empresa, contacto) VALUES(?, ?)";
	public static final int CONTADOR = 5;

	public static void main(String[] args) {
		int count = 0;
		try {
			Connection conexion = DataBaseConnection.connect();
			PreparedStatement ps = conexion.prepareStatement(SQL);
			ps.clearBatch();
			conexion.setAutoCommit(false);
			
			File file = new File("datos.csv");
			BufferedReader read = new BufferedReader(new FileReader(file));
			String linea;

			List<Empresa> datos = new ArrayList<>();

			while ((linea = read.readLine()) != null) {
				String[] partes = linea.split(";");
				Empresa emp = new Empresa(partes[0], partes[1]);
				datos.add(emp);
			}

			for (Empresa empresa : datos) {
				
				ps.setString(1, empresa.getNombre());
				ps.setString(2, empresa.getContacto());
				ps.addBatch();

				count++;
				if (count == CONTADOR) {
					ps.executeBatch();
					ps.clearBatch();
					count = 0;
					conexion.commit();
				}
			}
			conexion.commit();
			

			
			System.out.println("done");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
