package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.Movie;
import com.rental.movie.heavymetal.repositories.MovieRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class MovieServiceImplTest {


    @Autowired
    private MovieServiceImpl movieService;

    private static Long expectedId;
    private static Movie movie;


    @BeforeAll
    public static void init() {
         expectedId = 1L;
         movie = Movie.builder()
                .title("Test movie")
                .build();
    }

    @Test
     public void movieShouldBeAddedToRepository(){
        //when
        movieService.save(movie);
        Movie addedMovie = movieService.getById(expectedId);
        //then
        assertEquals(addedMovie.getTitle(), movie.getTitle());
    }

    @Test
    public void movieShouldBeFindable(){
        //when
        movieService.save(movie);
        Movie addedMovie = movieService.getById(expectedId);
        //then
        assertEquals(addedMovie.getTitle(), movie.getTitle());
    }    @Test
    public void movieShouldBeFindableByTitle(){
        //when
        movieService.save(movie);
        Movie addedMovie = movieService.findByTitle("Test movie").orElse(null);
        //then
        assertEquals(addedMovie.getTitle(), movie.getTitle());
    }

    @Test
    public void movieShouldBeUpdated(){
        //when
        String updatedTitle = "Update title";
        movieService.save(movie);
        Movie movie = movieService.getById(expectedId);
        movie.setTitle(updatedTitle);
        movieService.update(movie);
        Movie updatedMovie = movieService.getById(expectedId);
        //then
        assertEquals(updatedMovie.getId(), movie.getId());
        assertEquals(updatedTitle, updatedMovie.getTitle());

    }

    @Test
    public void movieShouldBeDeleted(){
        //when
        movieService.save(movie);
        movieService.delete(expectedId);
        //then
        Movie gotMovie = movieService.getById(expectedId);
        assertNull(gotMovie);
    }


}