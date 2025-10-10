package com.example.moviecatalog;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final List<Movie> movies = new ArrayList<>();

    // ✅ GET /movies — แสดงหนังทั้งหมด
    @GetMapping
    public List<Movie> getAllMovies() {
        return movies;
    }

    // ✅ POST /movies/add?title=Inception&director=Nolan&releaseYear=2010 — เพิ่มหนังใหม่
    @PostMapping("/add")
    public String addMovie(@RequestParam String title,
                           @RequestParam String director,
                           @RequestParam int releaseYear) {
        Movie newMovie = new Movie(title, director, releaseYear);
        movies.add(newMovie);
        return "Added movie: " + title + " (" + releaseYear + ")";
    }

    // ✅ GET /movies/search?title=Inception — ค้นหาหนัง
    @GetMapping("/search")
    public Object searchMovie(@RequestParam String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return "Movie with title '" + title + "' not found.";
    }
}
