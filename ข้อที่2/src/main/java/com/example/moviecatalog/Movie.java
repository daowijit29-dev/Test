                                                                                                                                                                                                                                                                                                                                                                            package com.example.moviecatalog;

public class Movie {
    private String title;
    private String director;
    private int releaseYear;

    // Constructor
    public Movie(String title, String director, int releaseYear) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    // Getters only (no setters)
    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
}
