package com.rental.movie.heavymetal.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CustomerOrders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;

    @ManyToOne
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Delivery delivery;

    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;
}
