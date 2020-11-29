package com.rental.movie.heavymetal.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Cart {

    private Integer id;
    User user;
    List<Copy> copies;
}
