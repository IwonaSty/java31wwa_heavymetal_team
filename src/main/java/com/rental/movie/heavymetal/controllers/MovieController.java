package com.rental.movie.heavymetal.controllers;

import com.rental.movie.heavymetal.services.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
