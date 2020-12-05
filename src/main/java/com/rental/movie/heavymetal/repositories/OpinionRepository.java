package com.rental.movie.heavymetal.repositories;

import com.rental.movie.heavymetal.model.opinion.Opinion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepository extends CrudRepository<Opinion,Long> {
}
