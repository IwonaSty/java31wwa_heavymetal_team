package com.rental.movie.heavymetal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Data
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
