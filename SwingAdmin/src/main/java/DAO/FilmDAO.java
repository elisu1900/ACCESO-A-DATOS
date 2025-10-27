import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DataBaseConnection;
import model.Film;

// EN EL VIEW FALTAN 2 CAMPOS MAS Y EN TODO LO QUE DESCIENDE DE ESTE

public class FilmDAO {
    
    // Método para traer TODAS las películas
    public List<Film> getAllFilms() {
        List<Film> films = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            // 1. Obtener conexión a la BD
            conn = DataBaseConnection.conectar();
            
            // 2. Preparar la consulta SQL
            String sql = "SELECT * FROM film";
            ps = conn.prepareStatement(sql);
            
            // 3. Ejecutar la consulta
            rs = ps.executeQuery();
            
            // 4. Recorrer los resultados
            while(rs.next()) {
                // 5. Crear un objeto Film por cada fila
                Film film = new Film();
                film.setId(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setReleaseYear(rs.getInt("release_year"));
                film.setLanguageId(rs.getInt("language_id"));
                film.setOriginalLanguageId(rs.getInt("original_language_id"));
                film.setRentalRate(rs.getDouble("rental_rate"));
                
                // 6. Añadir el objeto a la lista
                films.add(film);
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            // 7. Cerrar recursos
            try {
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(conn != null) conn.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        
        // 8. Devolver la lista
        return films;
    }
}