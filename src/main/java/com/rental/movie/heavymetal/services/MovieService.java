package com.rental.movie.heavymetal.services;

import com.rental.movie.heavymetal.model.Movie;

import java.util.List;

public interface MovieService {

    void save(Movie movie);

    Movie getById(Long id);

    List<Movie> getAll();

    void update(Movie movie);

    void delete(Long id);
}
