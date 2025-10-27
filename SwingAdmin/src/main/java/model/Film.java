package model;

public class Film {
    private int id;
    private String title;
    private int releaseYear;
    private double rentalRate;
    
    // Constructor vacío
    public Film() {
    }
    
    // Constructor con parámetros
    public Film(int id, String title, int releaseYear, double rentalRate) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.rentalRate = rentalRate;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", rentalRate=" + rentalRate +
                '}';
    }
}