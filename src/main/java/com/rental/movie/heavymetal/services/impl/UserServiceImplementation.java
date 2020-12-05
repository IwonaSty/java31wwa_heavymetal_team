package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.User;
import com.rental.movie.heavymetal.repositories.UserRepository;
import com.rental.movie.heavymetal.services.UserService;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class UserServiceImplementation implements UserService {

    UserRepository userRepository;

    public UserServiceImplementation(UserRepository repository) {
        this.userRepository = repository;
    }


    @Override
    public void save(User User) {
        userRepository.save(User);
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return new LinkedList<User>((Collection<? extends User>) userRepository.findAll());
    }

    @Override
    public void update(User User) {
        userRepository.save(User);

    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);

    }
}
