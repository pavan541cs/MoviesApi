package com.lowes.movieapp.controller.dto;

import com.lowes.movieapp.model.Genre;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class CreateMovieDto {
    @Schema(example = "tt5580036")
    @NotBlank
    private String imdb;

    @Schema(example = "I, Tonya")
    @NotBlank
    private String title;

    @Schema(example = "2017")
    @Positive
    private Short year;

    @Schema(example = "Biography")
    @NotNull
    private Genre genre;

    @Schema(example = "USA")
    @NotBlank
    private String country;
}
