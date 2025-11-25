package main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import config.DataBaseConnection;
/**
 * Clase Main para llamar al procedure
 */
public class MainApp {
    public static void main(String[] args) throws SQLException {

        Connection conexion = DataBaseConnection.connect();
        int totalRegistros =0;
        try {
            conexion.setAutoCommit(false);            
            String sql = "{CALL obtener_iniciales_por_id(?,?)}";
            CallableStatement cs = conexion.prepareCall(sql);
            
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM  alumnos");

            if (rs.next()) {
                totalRegistros = rs.getInt(1);
            }
            
            for(int i = 1; i<=totalRegistros ;i++) {
                cs.setInt(1, i);
                cs.registerOutParameter(2, Types.CHAR);
                cs.execute(); 
                String iniciales = cs.getString(2);
                System.out.println("ID " + i + ": " + iniciales);
            }
            conexion.commit();
            cs.close();
            st.close();
            conexion.close();
            
        }catch(Exception e) {
            e.printStackTrace();
            conexion.rollback();
        }
    }
}