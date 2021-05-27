package com.lowes.movieapp.service;

import com.lowes.movieapp.exception.MovieNotFoundException;
import com.lowes.movieapp.model.Movie;
import com.lowes.movieapp.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public Movie validateAndGetMovie(String imdb) {
        return movieRepository.findById(imdb).orElseThrow(() -> new MovieNotFoundException(imdb));
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        movieRepository.delete(movie);
    }
}
