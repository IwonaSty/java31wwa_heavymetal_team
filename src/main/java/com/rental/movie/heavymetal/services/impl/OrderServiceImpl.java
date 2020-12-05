package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.Order;
import com.rental.movie.heavymetal.repositories.OrderRepository;
import com.rental.movie.heavymetal.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Order order) {
        repository.save(order);
    }

    @Override
    public Order getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = new LinkedList<>();
        repository.findAll().iterator().forEachRemaining(orders::add);
        return orders;
    }

    @Override
    public void update(Order order) {
        repository.save(order);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
