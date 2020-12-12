package com.rental.movie.heavymetal.controllers;

import com.rental.movie.heavymetal.model.Genre;
import com.rental.movie.heavymetal.model.Movie;
import com.rental.movie.heavymetal.services.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.LinkedList;

@Slf4j
@Controller
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping({"/movies"})
    public String getMovieIndex(Model model) {
        model.addAttribute("movies", service.getAll());
        return "movies/index";
    }

    @GetMapping("/movie")
    public String getOneWorker(@RequestParam Long id, Model model) {

        model.addAttribute("movie",service.getById(id));

        return "movies/movie";

    }

    @GetMapping("/add-movie")
    public String newMovie(Model model) {
        model.addAttribute("genre", new LinkedList<Genre>(Arrays.asList(Genre.values())));
        model.addAttribute("movie", new Movie());
        return "movies/add-movie";
    }

    @PostMapping("/save-movie")
    public String saveMovie(@ModelAttribute Movie movie) {
        service.save(movie);
        log.info("Added movie: " + movie);

        return "redirect:/movies";
    }

}
