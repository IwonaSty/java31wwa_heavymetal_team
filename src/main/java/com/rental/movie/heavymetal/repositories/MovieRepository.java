package com.rental.movie.heavymetal.repositories;

import com.rental.movie.heavymetal.model.Genre;
import com.rental.movie.heavymetal.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;


@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    Optional<Movie> findByTitle(String title);
    Optional<Movie> findByDirector(String director);
    Optional<Movie> findByGenre(Genre genre);


}
