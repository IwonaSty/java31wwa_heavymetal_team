package com.rental.movie.heavymetal.repositories;

import com.rental.movie.heavymetal.model.Genre;
import com.rental.movie.heavymetal.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.Set;


@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    Optional<Movie> findByTitle(String title);
    Optional<Movie> findByDirector(String director);
    Optional<Movie> findByGenre(Genre genre);
    Optional<Movie> findByTitleAndDirector(String title,String director);
    Optional<Movie> findByTitleAndGenre(String title,Genre genre);
    Optional<Movie> findByTitleAndGenreAndDirector(String title,Genre genre,String director);

    Set<Movie> findAllByGenre(Genre genre);


}
