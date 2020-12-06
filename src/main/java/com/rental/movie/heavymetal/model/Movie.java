package com.rental.movie.heavymetal.model;

import com.rental.movie.heavymetal.model.opinion.Opinion;
import lombok.*;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String director;

    @Enumerated
    private Genre genre;

    private LocalDate releaseDate;

    private String description;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "movie")
    private Set<Copy> copies;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "movie")
    private Set<Opinion> opinions;

   /* public Movie() {
    }*/
}