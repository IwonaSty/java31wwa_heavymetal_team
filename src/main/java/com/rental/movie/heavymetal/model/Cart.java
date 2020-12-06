package com.rental.movie.heavymetal.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Order order;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private List<Copy> copies;
}
