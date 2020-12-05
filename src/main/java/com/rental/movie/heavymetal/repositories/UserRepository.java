package com.rental.movie.heavymetal.repositories;

import com.rental.movie.heavymetal.model.Movie;
import com.rental.movie.heavymetal.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
