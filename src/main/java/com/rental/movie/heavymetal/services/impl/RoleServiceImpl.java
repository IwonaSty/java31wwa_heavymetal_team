package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.Role;
import com.rental.movie.heavymetal.repositories.RoleRepository;
import com.rental.movie.heavymetal.services.RoleService;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
