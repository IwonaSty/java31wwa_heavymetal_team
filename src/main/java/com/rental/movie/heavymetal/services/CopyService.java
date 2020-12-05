package com.rental.movie.heavymetal.services;

import com.rental.movie.heavymetal.model.Copy;

import java.util.List;

public interface CopyService {


    public void save(Copy copy);

    public Copy getById(Long id);

    public List<Copy> getAll();

    public void update(Copy copy);

    public void delete(Long id);

}
