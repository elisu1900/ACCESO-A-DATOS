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
 * muestra las peliculas por pantalla
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
	 * @param filmId
	 */
	private void loadActors(int filmId) {
        view.getModel().setRowCount(0);
        
        List<Actor> actors = filmDao.getActorFilm(filmId);
        
        for (Actor actor : actors) {
            view.getModel().addRow(new Object[]{
                actor.getId(),
                actor.getFirstName(),
                actor.getLastName()
            });
        }        
    }

}
