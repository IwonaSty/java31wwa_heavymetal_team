package com.rental.movie.heavymetal.controllers;

import com.rental.movie.heavymetal.model.Genre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Controller
public class indexController {
    @GetMapping({"/","","/index"})
    public String index() {

//        List<Genre> genres = new LinkedList<>();
//        Arrays.stream(Genre.values()).sorted().forEach(genres::add);
//        model.addAttribute("genres", genres);
        return "index";

    }

    @GetMapping("/notImplemented")
    public String notImplemented() {
        return "notImplemented";
    }

}
