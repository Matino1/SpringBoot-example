package com.example.demo.MoviesLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie) {
        Optional<Movie> movieByTitle = movieRepository.findMovieByTitle(movie.getTitle());

        if (movieByTitle.isPresent()) {
            throw  new IllegalStateException("movie exist");
        }
        movieRepository.save(movie);
    }

    public void deleteMovie(long id) {
        boolean exists = movieRepository.existsById(id);

        if(!exists) {
            throw  new IllegalStateException("movie not exist");
        }
        movieRepository.deleteById(id);
    }

    @Transactional
    public void updateMovie(long id, String title, String director, Double rating) {

        Movie movie = movieRepository.findById(id).orElseThrow(() -> new IllegalStateException("movie not exist"));

        if (title != null && !title.isEmpty() && !Objects.equals(movie.getTitle(), title)) {

            Optional<Movie> movieOptional =  movieRepository.findMovieByTitle(title);
            if (movieOptional.isPresent()) {
                throw new IllegalStateException("movie exist");
            }
            movie.setTitle(title);
        }

        if (director != null && !director.isEmpty() && !Objects.equals(movie.getDirector(), director)) {
            movie.setDirector(director);
        }

        if (rating != null && rating > 0 && rating < 10  && movie.getRating() != rating) {
            movie.setRating(rating);
        }

    }
}
