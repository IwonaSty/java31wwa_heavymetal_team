package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.Cart;
import com.rental.movie.heavymetal.repositories.CarRepository;
import com.rental.movie.heavymetal.services.CartService;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CartServiceImplementation implements CartService {
    CarRepository cartRepositories ;

    public CartServiceImplementation(CarRepository repository) {
        this.cartRepositories = repository;
    }
    @Override
    public void save(Cart Cart) {
        cartRepositories.save(Cart);

    }

    @Override
    public Cart getById(Integer id) {
        return cartRepositories.findById(id).orElse(null);
    }

    @Override
    public List<Cart> getAll() {
        return new LinkedList<Cart>((Collection<? extends Cart>) cartRepositories.findAll());
    }

    @Override
    public void update(Cart Cart) {
        cartRepositories.save(Cart);

    }

    @Override
    public void delete(Integer id) {
        cartRepositories.deleteById(id);


    }
}
