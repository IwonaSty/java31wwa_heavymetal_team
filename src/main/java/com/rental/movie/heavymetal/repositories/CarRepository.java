package com.rental.movie.heavymetal.repositories;

import com.rental.movie.heavymetal.model.Cart;
import com.rental.movie.heavymetal.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Cart, Integer> {
}
