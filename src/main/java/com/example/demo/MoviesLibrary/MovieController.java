package com.example.demo.MoviesLibrary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @PostMapping
    public void addNewMovie(@RequestBody Movie movie) {
       movieService.addMovie(movie);
    }

    @DeleteMapping(path = "{movieId}")
    public void deleteMovie(@PathVariable("movieId") long id) {
        movieService.deleteMovie(id);
    }

    @PutMapping(path = "{movieId}")
    public void updateMovie(@PathVariable("movieId") long id,
                            @RequestParam(required = false) String title,
                            @RequestParam(required = false) String director,
                            @RequestParam(required = false) Double rating) {
        movieService.updateMovie(id, title, director, rating);
    }

}
