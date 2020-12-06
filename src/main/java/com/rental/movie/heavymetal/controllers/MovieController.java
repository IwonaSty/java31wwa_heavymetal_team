package com.rental.movie.heavymetal.controllers;

import com.rental.movie.heavymetal.services.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
