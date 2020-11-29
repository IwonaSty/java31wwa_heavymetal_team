package com.rental.movie.heavymetal.model;

import com.rental.movie.heavymetal.model.rating.GlobalRating;
import com.rental.movie.heavymetal.model.rating.Mark;



import java.time.LocalDate;

public class Movie {

    private int id;
    private String title;
    private String director;
    private Genre genre;
    private LocalDate releaseDate;
    private String description;
    private GlobalRating globalrating;



}
