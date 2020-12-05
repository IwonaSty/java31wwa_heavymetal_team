package com.rental.movie.heavymetal.services;

import com.rental.movie.heavymetal.model.Movie;
import com.rental.movie.heavymetal.model.User;

import java.util.List;

public interface UserService {
    void save(User User);

    User getById(Integer id);

    List<User> getAll();

    void update(User User);

    void delete(Integer id);
}
