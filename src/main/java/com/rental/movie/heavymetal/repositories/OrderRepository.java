package com.rental.movie.heavymetal.repositories;

import com.rental.movie.heavymetal.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {
}
