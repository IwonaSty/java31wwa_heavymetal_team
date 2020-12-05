package com.rental.movie.heavymetal.services;

import com.rental.movie.heavymetal.model.Delivery;
import com.rental.movie.heavymetal.model.Movie;

import java.util.List;

public interface DeliveryService {

    void save (Delivery delivery);

    Delivery getById (Long id);

    List<Delivery> getAll();

    void update(Delivery delivery);

    void delete(Long id);





}
