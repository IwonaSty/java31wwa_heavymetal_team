package com.rental.movie.heavymetal.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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

    @ElementCollection
    @CollectionTable(name = "order_copy_mapping",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "copy_id")
    @Column(name = "rentalDays")
    private Map<Copy, Integer> copiesWithRentalDays = new HashMap<>();

    @ManyToOne
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Delivery delivery;

  /*  @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;*/
}
