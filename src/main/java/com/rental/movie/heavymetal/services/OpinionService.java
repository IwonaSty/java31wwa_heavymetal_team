package com.rental.movie.heavymetal.services;

import com.rental.movie.heavymetal.model.Movie;
import com.rental.movie.heavymetal.model.opinion.Opinion;

import java.util.List;

public interface OpinionService {


    void save(Opinion opinion);

    Opinion getById(Long id);

    List<Opinion> getAll();

    void update(Opinion opinion);

    void delete(Long id);
}
