package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.Genre;
import com.rental.movie.heavymetal.model.Movie;
import com.rental.movie.heavymetal.repositories.MovieRepository;
import com.rental.movie.heavymetal.services.MovieService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService {

    MovieRepository repository;

    public MovieServiceImpl (MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Movie movie) {
        repository.save(movie);
    }

    @Override
    public Movie getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> movies = new LinkedList<>();
        repository.findAll().iterator().forEachRemaining(movies::add);
        return movies;
    }

    @Override
    public void update(Movie movie) {
        repository.save(movie);

    }

    @Override
    public void delete(Long id) {

        repository.deleteById(id);

    }

    @Override
    public Movie findByTitle(String Title) {
        return repository.findByTitle(Title).orElse(null);
    }

    @Override
    public Movie findByDirector(String director) {
        return  repository.findByDirector(director).orElse(null);
    }

    @Override
    public Movie findByGenre(Genre genre) {
        return repository.findByGenre(genre).orElse(null);
    }

    @Override
    public Set<Movie> findAllByGenre(Genre genre) {
        return repository.findAllByGenre(genre);
    }


}
