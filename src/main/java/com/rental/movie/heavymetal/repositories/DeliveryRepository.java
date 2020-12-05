package com.rental.movie.heavymetal.repositories;

import com.rental.movie.heavymetal.model.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface DeliveryRepository extends CrudRepository <Delivery, Long> {


    }


