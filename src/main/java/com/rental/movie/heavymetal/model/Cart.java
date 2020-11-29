package com.rental.movie.heavymetal.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Cart {

    private Integer id;
    private User user;
    private List<Copy> copies;
}
