package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.User;
import com.rental.movie.heavymetal.repositories.UserRepository;
import com.rental.movie.heavymetal.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

   private final UserRepository userRepository;



    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        List<User> users = new LinkedList<>();
        userRepository.findAll().iterator().forEachRemaining(users::add);
        return users;
    }

    @Override
    public void update(User user) {
        userRepository.save(user);

    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);

    }
}
