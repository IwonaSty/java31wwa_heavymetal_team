package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.Copy;
import com.rental.movie.heavymetal.repositories.CopyRepository;
import com.rental.movie.heavymetal.services.CopyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CopyServiceImpl implements CopyService {

    private final CopyRepository copyRepository;

    @Override
    public void save(Copy copy) {
        copyRepository.save(copy);
    }

    @Override
    public Copy getById(Long id) {
        return copyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Copy> getAll() {
        return new LinkedList<Copy>((Collection<? extends Copy>) copyRepository.findAll());
    }

    @Override
    public void update(Copy copy) {
        copyRepository.save(copy);
    }

    @Override
    public void delete(Long id) {
        copyRepository.deleteById(id);
    }


}
