package com.rental.movie.heavymetal.services;

import com.rental.movie.heavymetal.model.Cart;
import com.rental.movie.heavymetal.model.Movie;

import java.util.List;

public interface CartService {
    void save(Cart Cart);

    Cart getById(Integer id);

    List<Cart> getAll();

    void update(Cart Cart);

    void delete(Integer id);
}
