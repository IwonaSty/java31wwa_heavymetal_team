package com.rental.movie.heavymetal.services;

import com.rental.movie.heavymetal.model.Role;


public interface RoleService {

    Role save(Role role);

    Role findByName(String name);
}
