package com.rental.movie.heavymetal.services;

import com.rental.movie.heavymetal.model.Genre;
import com.rental.movie.heavymetal.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    void save(Movie movie);

    Movie getById(Long id);

    List<Movie> getAll();

    void update(Movie movie);

    void delete(Long id);

    Movie findByTitle(String Title);

    Movie findByDirector(String director);

    Movie findByGenre(Genre genre);


}
