package com.rental.movie.heavymetal.controllers;

import com.rental.movie.heavymetal.model.Genre;
import com.rental.movie.heavymetal.model.User;
import org.dom4j.rule.Mode;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Controller
public class indexController {
    @GetMapping({"/","","/index"})
    public String index(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("currentUser", user);
        return "index";
    }
    @GetMapping("/notImplemented")
    public String notImplemented() {
        return "notImplemented";
    }
}
