package com.rental.movie.heavymetal.repositories;

import com.rental.movie.heavymetal.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String name);

}
