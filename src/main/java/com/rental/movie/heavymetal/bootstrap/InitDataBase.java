package com.rental.movie.heavymetal.bootstrap;

import com.rental.movie.heavymetal.model.Genre;
import com.rental.movie.heavymetal.model.Movie;
import com.rental.movie.heavymetal.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InitDataBase implements CommandLineRunner {
    private final MovieRepository movieRepository;

    public InitDataBase(final MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        initMovies();
    }

    public void initMovies() {

        Movie movie1 = Movie.builder()
                .title("The Big Blue")
                .director("Luc Besson")
                .releaseDate(LocalDate.of(1988, 1, 1))
                .genre(Genre.DRAMA)
                .description("Wielki błękit (fr. Le grand bleu, ang. The Big Blue) – francusko-amerykańsko-włoski " +
                        "dramat obyczajowy z 1988 r. w reżyserii Luca Bessona")
                .build();
        movieRepository.save(movie1);

        Movie movie2 = Movie.builder()
                .title("Pitbull Ostatni Pies")
                .director("Władysław Pasikowski")
                .releaseDate(LocalDate.of(2018, 6, 6))
                .genre(Genre.ACTION)
                .description("Ostatni pies to super film")
                .build();
        movieRepository.save(movie2);

        Movie movie3 = Movie.builder()
                .title("SINISTER")
                .director("Scott Derrickson")
                .releaseDate(LocalDate.of(2012,03,2))
                .genre(Genre.HORROR)
                .description("Autor powieści kryminalnych po przeprowadzce znajduje na strychu projektor ze " +
                        "starymi taśmami.")
                .build();
        movieRepository.save(movie3);

        Movie movie4 = Movie.builder()
                .title("The good, the bad and the ugly")
                .genre(Genre.WESTERN)
                .director("Sergio Leone")
                .releaseDate(LocalDate.of(1966, 12, 12))
                .description("just good western")
                .build();
        movieRepository.save(movie4);



    }



}