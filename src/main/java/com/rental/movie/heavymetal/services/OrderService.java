package com.rental.movie.heavymetal.services;

import com.rental.movie.heavymetal.model.Order;
import com.rental.movie.heavymetal.model.opinion.Opinion;

import java.util.List;

public interface OrderService{

    void save(Order order);

    Order getById(Long id);

    List<Order> getAll();

    void update(Order order);

    void delete(Long id);

}
