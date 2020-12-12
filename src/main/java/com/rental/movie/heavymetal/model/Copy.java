package com.rental.movie.heavymetal.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Copy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

/*    @ManyToOne
    private Cart cart;*/

    @ManyToOne
    private Movie movie;
//    private boolean isRented;
//    private User user;


}
