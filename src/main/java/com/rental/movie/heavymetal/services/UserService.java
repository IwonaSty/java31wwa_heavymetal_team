package com.rental.movie.heavymetal.services;

import com.rental.movie.heavymetal.model.Movie;
import com.rental.movie.heavymetal.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User getById(Long id);

    List<User> getAll();

    void update(User user);

    void delete(Long id);

    User findByEmail(String email);


}
