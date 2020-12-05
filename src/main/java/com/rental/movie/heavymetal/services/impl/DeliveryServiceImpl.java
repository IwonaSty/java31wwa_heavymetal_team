package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.Delivery;
import com.rental.movie.heavymetal.repositories.DeliveryRepository;
import com.rental.movie.heavymetal.services.DeliveryService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    DeliveryRepository deliveryRepository;

    public DeliveryServiceImpl (DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public void save(Delivery delivery) {
        deliveryRepository.save(delivery);
    }


    @Override
    public Delivery getById(Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Delivery> getAll() {
        return new LinkedList<Delivery>((Collection<? extends Delivery>) deliveryRepository.findAll());
    }

    @Override
    public void update(Delivery delivery) {
        deliveryRepository.save(delivery);

    }

    @Override
    public void delete(Long id) {
        deliveryRepository.deleteById(id);

    }
}
