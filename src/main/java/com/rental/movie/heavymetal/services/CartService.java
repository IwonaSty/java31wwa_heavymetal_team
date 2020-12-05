package com.rental.movie.heavymetal.services;

import com.rental.movie.heavymetal.model.Cart;
import com.rental.movie.heavymetal.model.Movie;

import java.util.List;

public interface CartService {
    void save(Cart cart);

    Cart getById(Long id);

    List<Cart> getAll();

    void update(Cart cart);

    void delete(Long id);
}
