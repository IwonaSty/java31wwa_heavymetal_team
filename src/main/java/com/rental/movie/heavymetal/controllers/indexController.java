package com.rental.movie.heavymetal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    @GetMapping({"/",""})
    public String index() {

        return "index";

    }

    @GetMapping("/notImplemented")
    public String notImplemented() {
        return "notImplemented";
    }

}
