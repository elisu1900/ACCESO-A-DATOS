package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import DAO.FilmDAO;
import model.Actor;
import model.Film;
import views.MainView;

public class FilmController {

	private MainView view;
	private FilmDAO filmDao;
	private List<Film> films;
	private int index;
	private boolean isNewMode = false;

	/**
	 * constructor de la clase
	 * 
	 * @param view
	 */
	public FilmController(MainView view) {
		this.view = view;
		this.filmDao = new FilmDAO();
		this.index = 0;
		initController();
	}

	/**
	 * metodo de inicialización
	 */
	private void initController() {
		loadAllFilms();

		addListeners();

		if (films != null && !films.isEmpty()) {
			displayFilm(films.get(0));
		} else {
			JOptionPane.showMessageDialog(view, "No hay películas en la BD");
		}
	}

	/**
	 * Cargamos todas las peliculas
	 */
	private void loadAllFilms() {
		films = filmDao.getAllFilms();
	}

	/**
	 * Añadimos funcionameito a los botones
	 */
	private void addListeners() {
		view.getBtnFirst().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showFirst();
			}
		});

		view.getBtnBefore().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showBefore();
			}
		});

		view.getBtnAfter().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showAfter();
			}
		});
		view.getBtnLast().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showLast();
			}
		});

		view.getBtnLimpiar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});
		view.getBtnCrear().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFilm();
			}
		});
	}

	/**
	 * muestra el primer registro de pelicula
	 */
	private void showFirst() {
		index = 0;
		displayFilm(films.get(index));
	}

	/**
	 * muestra el registro anterior de pelicula
	 */
	private void showBefore() {
		if (index > 0) {
			index--;
			displayFilm(films.get(index));
		} else {
			JOptionPane.showMessageDialog(view, "Ya estas en la primera pelicula");
		}
	}

	/**
	 * muestra el registro siguiente de pelicula
	 */
	private void showAfter() {
		if (index < films.size() - 1) {
			index++;
			displayFilm(films.get(index));
		}
	}

	/**
	 * muestra el ultimo registro de pelicula
	 */
	private void showLast() {
		index = films.size() - 1;
		displayFilm(films.get(index));

	}

	/**
	 * limpia los campos de la pantalla
	 */
	private void clearFields() {
		view.getTxtId().setText("");
		view.getTxtTitle().setText("");
		view.getTxtRelease_year().setText("");
		view.getTxtRating().setText("");

		view.getModel().setRowCount(0);

		view.getTxtId().setEditable(false);
		isNewMode = true;
	}

	/**
	 * muestra las peliculas por pantalla
	 * 
	 * @param film
	 */
	private void displayFilm(Film film) {

		view.getTxtId().setText(String.valueOf(film.getId()));
		view.getTxtTitle().setText(film.getTitle());
		view.getTxtRelease_year().setText(String.valueOf(film.getReleaseYear()));
		view.getTxtRating().setText(String.valueOf(film.getRentalRate()));

		loadActors(film.getId());

	}

	/**
	 * carga y muestra los actores de la pelicula con id filmId
	 * 
	 * @param filmId
	 */
	private void loadActors(int filmId) {
		view.getModel().setRowCount(0);

		List<Actor> actors = filmDao.getActorsByFilmId(filmId);

		for (Actor actor : actors) {
			view.getModel().addRow(new Object[] { actor.getId(), actor.getFirstName(), actor.getLastName() });
		}
	}

	/**
	 * metodo que comprueba y guarda los datos de la pantalla en la base de datos
	 */
	private void saveFilm() {
		try {
			if (view.getTxtTitle().getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(view, "El título no puede estar vacío");
				return;
			}

			if (view.getTxtRelease_year().getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(view, "El año no puede estar vacío");
				return;
			}

			if (view.getTxtRating().getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(view, "El rental rate no puede estar vacío");
				return;
			}

			Film film = new Film();
			film.setTitle(view.getTxtTitle().getText().trim());
			film.setReleaseYear(Integer.parseInt(view.getTxtRelease_year().getText().trim()));
			film.setRentalRate(Double.parseDouble(view.getTxtRating().getText().trim()));

			boolean success = false;

			if (isNewMode) {
				success = filmDao.insertFilm(film);
				if (success) {
					JOptionPane.showMessageDialog(view, "Película creada correctamente");
					loadAllFilms();
					showLast();
					isNewMode = false;
				} else {
					JOptionPane.showMessageDialog(view, "Error al crear la película");
				}
			} else {
				film.setId(Integer.parseInt(view.getTxtId().getText()));
				success = filmDao.updateFilm(film);
				if (success) {
					JOptionPane.showMessageDialog(view, "Película actualizada correctamente");
					loadAllFilms();
					displayFilm(films.get(index));
				} else {
					JOptionPane.showMessageDialog(view, "Error al actualizar la película");
				}
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(view, "Error: Los campos numéricos deben contener números válidos");
			e.printStackTrace();
		}
	}

}
