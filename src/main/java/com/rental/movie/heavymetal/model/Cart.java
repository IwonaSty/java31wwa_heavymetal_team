package com.rental.movie.heavymetal.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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

    private BigDecimal costSummary;

    @Transient
    private Map<Copy, Integer> daysOfRenting;

}
