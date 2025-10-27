package main;

import controller.FilmController;
import views.MainView;

public class MainApp {

	public static void main(String[] args) {
	
		MainView view = new MainView();
		FilmController controller = new FilmController(view);
		view.setVisible(true);
	}
}
