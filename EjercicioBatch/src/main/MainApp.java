package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;

import config.DataBaseConnection;

public class MainApp {

	public static final String SQL = "INSERT(empresa) VALUES(?)";
	public static final int CONTADOR = 5;
	
	public static void main(String[] args) {
		int count =0;
		try {
			Connection conexion = DataBaseConnection.connect();
			PreparedStatement ps = conexion.prepareStatement(SQL);
			
			conexion.setAutoCommit(false);
			
			for (int i = 0; i < 20; i++) {
				String empresa = "empresa"+i;
				ps.setString(i,empresa);
				count++;
				if(count == CONTADOR) {
					ps.addBatch();
					count = 0;
				}
			}
			ps.executeBatch();
			
		} catch (Exception e) {
		}

		
		
	}
}
