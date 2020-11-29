package com.rental.movie.heavymetal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Integer id;

    private LocalDate orderDate;

    private Cart cart;
}
