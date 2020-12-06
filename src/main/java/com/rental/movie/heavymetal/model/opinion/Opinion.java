package com.rental.movie.heavymetal.model.opinion;

import com.rental.movie.heavymetal.model.Movie;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userComment;
    private Double rating;

    @ManyToOne
    private Movie movie;

}
