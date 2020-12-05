package com.rental.movie.heavymetal.model.opinion;

import com.rental.movie.heavymetal.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
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
