package com.rental.movie.heavymetal.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Order order;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private List<Copy> copies;
}
