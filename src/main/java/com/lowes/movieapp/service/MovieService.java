package com.lowes.movieapp.service;

import com.lowes.movieapp.model.Movie;

import java.util.List;

public interface MovieService {
    Movie validateAndGetMovie(String imdb);
    List<Movie> getMovies();
    Movie createMovie(Movie movie);
    void deleteMovie(Movie movie);
}
