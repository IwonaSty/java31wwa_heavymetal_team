package com.rental.movie.heavymetal.repositories;

import com.rental.movie.heavymetal.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
}
