package com.lowes.movieapp.mapper;

import com.lowes.movieapp.controller.dto.CreateMovieDto;
import com.lowes.movieapp.model.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    Movie toMovie(CreateMovieDto createMovieDto);
}
