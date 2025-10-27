package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DataBaseConnection;
import model.Actor;
import model.Film;

// EN EL VIEW FALTAN 2 CAMPOS MAS Y EN TODO LO QUE DESCIENDE DE ESTE

public class FilmDAO {

	public List<Film> getAllFilms() {
		List<Film> films = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DataBaseConnection.conectar();

			String sql = "SELECT * FROM film";
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				Film film = new Film();
				film.setId(rs.getInt("film_id"));
				film.setTitle(rs.getString("title"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setRentalRate(rs.getDouble("rental_rate"));

				films.add(film);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
				if (conn != null)
					DataBaseConnection.desconectar(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return films;
	}

	public List<Actor> getActorFilm(int filmId) {
		List<Actor> actors = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DataBaseConnection.conectar();

			String sql = "select actor.*, film_actor.film_id from actor "
			           + "join film_actor on actor.actor_id = film_actor.actor_id "
			           + "where film_actor.film_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,filmId);

			rs = ps.executeQuery();

			while (rs.next()) {
				Actor actor = new Actor();
				actor.setId(rs.getInt("actor_id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));

				actors.add(actor);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
				if (conn != null)
					DataBaseConnection.desconectar(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return actors;

	}
}