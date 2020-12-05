package com.rental.movie.heavymetal.repositories;

import com.rental.movie.heavymetal.model.Copy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CopyRepository extends CrudRepository<Copy, Long> {
}
