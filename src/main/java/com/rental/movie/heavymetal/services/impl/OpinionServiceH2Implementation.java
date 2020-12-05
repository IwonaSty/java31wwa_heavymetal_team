package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.opinion.Opinion;
import com.rental.movie.heavymetal.repositories.OpinionRepository;
import com.rental.movie.heavymetal.services.OpinionService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
@Service
public class OpinionServiceH2Implementation implements OpinionService {


    OpinionRepository repository;

    public OpinionServiceH2Implementation(OpinionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Opinion opinion) {
        repository.save(opinion);

    }

    @Override
    public Opinion getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Opinion> getAll() {
        List<Opinion> opinions = new LinkedList<>();
        repository.findAll().iterator().forEachRemaining(opinions::add);
        return opinions;
    }

    @Override
    public void update(Opinion opinion) {
        repository.save(opinion);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
