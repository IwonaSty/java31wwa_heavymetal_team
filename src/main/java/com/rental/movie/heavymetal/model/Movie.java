package com.rental.movie.heavymetal.model;

import com.rental.movie.heavymetal.model.rating.GlobalRating;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
@Data
@NoArgsConstructor
public class Movie {

    private Integer id;

    private String title;

    private String director;

    private Genre genre;

    private LocalDate releaseDate;

    private String description;

    private GlobalRating globalrating;


}