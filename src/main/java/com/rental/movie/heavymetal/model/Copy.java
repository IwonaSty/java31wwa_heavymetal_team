package com.rental.movie.heavymetal.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Copy {

    private Integer id;
    private Movie movie;
    private boolean isRented;
    private User user;


}
