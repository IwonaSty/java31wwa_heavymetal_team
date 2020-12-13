package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.Role;
import com.rental.movie.heavymetal.model.User;
import com.rental.movie.heavymetal.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User userFromDb = userRepository.findByEmail(email);

        List<String> roleList = new ArrayList<>();

        for (Role role : userFromDb.getRoles()) {
            roleList.add(role.getName());
        }

        var springUser = org.springframework.security.core.userdetails.User.builder()
                .username(userFromDb.getEmail())
                .password(userFromDb.getPassword())
                .roles(roleList.toArray(new String[0]))
                .build();

        return springUser;
    }
}
