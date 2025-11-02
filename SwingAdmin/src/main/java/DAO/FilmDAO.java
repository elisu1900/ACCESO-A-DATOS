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

public class FilmDAO {
	/**
	 * trae todas las peliculas, crea instancias de ellas y luego las añade a la
	 * lista
	 * 
	 * @return
	 */
	public List<Film> getAllFilms() {
		List<Film> films = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DataBaseConnection.connect();

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
					DataBaseConnection.desconnect(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return films;
	}

	/**
	 * devuelve una lista de actores que participan en esa pelicula
	 * 
	 * @param filmId
	 * @return
	 */
	public List<Actor> getActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DataBaseConnection.connect();

			String sql = "select actor.*, film_actor.film_id from actor "
					+ "join film_actor on actor.actor_id = film_actor.actor_id " + "where film_actor.film_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, filmId);

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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return actors;

	}

	/**
	 * Inserta una nueva pelicula en la base de datos
	 * 
	 * @param film
	 * @return true si se ha insertado, false si falla
	 */
	public boolean insertFilm(Film film) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DataBaseConnection.connect();

			String sql = "INSERT INTO film (title, release_year, language_id, rental_duration, rental_rate, replacement_cost) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";

			ps = conn.prepareStatement(sql);
			ps.setString(1, film.getTitle());
			ps.setInt(2, film.getReleaseYear());
			ps.setInt(3, 1);
			ps.setInt(4, 3);
			ps.setDouble(5, film.getRentalRate());
			ps.setDouble(6, 19.99);

			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Actualiza una pelicula existente en la base de datos
	 * 
	 * @param film
	 * @return true si se actualizó, false si falla
	 */
	public boolean updateFilm(Film film) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DataBaseConnection.connect();

			String sql = "UPDATE film SET title = ?, release_year = ?, rental_rate = ? " + "WHERE film_id = ?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, film.getTitle());
			ps.setInt(2, film.getReleaseYear());
			ps.setDouble(3, film.getRentalRate());
			ps.setInt(4, film.getId());

			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}