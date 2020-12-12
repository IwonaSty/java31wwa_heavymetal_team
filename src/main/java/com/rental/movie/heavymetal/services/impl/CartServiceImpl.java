/*
package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.Cart;
import com.rental.movie.heavymetal.repositories.CartRepository;
import com.rental.movie.heavymetal.services.CartService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    CartRepository cartRepositories ;

    public CartServiceImpl(CartRepository repository) {
        this.cartRepositories = repository;
    }

    @Override
    public void save(Cart cart) {
        cartRepositories.save(cart);

    }

    @Override
    public Cart getById(Long id) {
        return cartRepositories.findById(id).orElse(null);
    }

    @Override
    public List<Cart> getAll() {
        List<Cart> carts = new LinkedList<>();
        cartRepositories.findAll().iterator().forEachRemaining(carts::add);
        return carts;
    }

    @Override
    public void update(Cart cart) {
        cartRepositories.save(cart);

    }

    @Override
    public void delete(Long id) {
        cartRepositories.deleteById(id);


    }
}
*/
