package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.Copy;
import com.rental.movie.heavymetal.model.Movie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CopyServiceImplTest {

    @Autowired
    private CopyServiceImpl copyService;
    @Autowired
    private MovieServiceImpl movieService;

    private static Long expectedId;
    private static Copy copy;
    private static Movie movie;

    @BeforeAll
    public static void init() {
        expectedId = 1L;
        movie = Movie.builder()
                .title("Test movie")
                .build();
        copy = Copy.builder()
                .movie(movie)
                .build();
    }

    @Test
    public void copyShouldBeAddedToRepository() {
        //when
        movieService.save(movie);
        copyService.save(copy);
        Copy addedCopy = copyService.getById(expectedId);
        //then
        assertEquals(addedCopy.getMovie().getTitle(), movie.getTitle());
    }

    @Test
    public void copyShouldBeFindable() {
        //when
        movieService.save(movie);
        copyService.save(copy);
        Copy addedCopy = copyService.getById(expectedId);
        //then
        assertEquals(addedCopy.getMovie().getTitle(), movie.getTitle());
    }

    @Test
    public void copyShouldBeUpdated() {
        //when
        Movie newMovie = Movie.builder()
                .title("New movie")
                .build();
        movieService.save(movie);
        movieService.save(newMovie);
        copyService.save(copy);
        Copy copy = copyService.getById(expectedId);
        copy.setMovie(newMovie);
        copyService.update(copy);
        Copy updatedCopy = copyService.getById(expectedId);
        //then
        assertEquals(updatedCopy.getId(), copy.getId());
        assertEquals(newMovie.getTitle(), updatedCopy.getMovie().getTitle());

    }

    @Test
    public void copyShouldBeDeleted() {
        //when
        movieService.save(movie);
        copyService.save(copy);
        copyService.delete(expectedId);
        //then
        Copy gotCopy = copyService.getById(expectedId);
        assertNull(gotCopy);
    }


}