package com.lowes.movieapp.controller;

import com.lowes.movieapp.controller.dto.CreateMovieDto;
import com.lowes.movieapp.mapper.MovieMapper;
import com.lowes.movieapp.model.Movie;
import com.lowes.movieapp.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private static final Logger LOG = LoggerFactory.getLogger(MovieController.class);
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    @GetMapping
    public List<Movie> getMovies() {
        List<Movie> movies = movieService.getMovies();
        LOG.info("Number of movies {}", movies.size());
        return movies;
    }

    @GetMapping("/{imdb}")
    public Movie getMovie(@PathVariable("imdb") String imdb) {
        if (imdb.equals("111")) {
            throw new NullPointerException("It is know there is a bug with this movie");
        }
        LOG.info("Get movie {}", imdb);
        return movieService.validateAndGetMovie(imdb);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Movie createMovie(@Valid @RequestBody Movie movie) {
//        Movie movie = movieMapper.toMovie(createMovieDto);
        movie = movieService.createMovie(movie);
        LOG.info("Movie created {}", movie.getImdb());
        return movie;
    }

    @DeleteMapping("/{imdb}")
    public String deleteMovie(@PathVariable("imdb") String imdb) {
        Movie movie = movieService.validateAndGetMovie(imdb);
        movieService.deleteMovie(movie);
        LOG.info("Movie deleted {}", movie.getImdb());
        return movie.getImdb();
    }
}
