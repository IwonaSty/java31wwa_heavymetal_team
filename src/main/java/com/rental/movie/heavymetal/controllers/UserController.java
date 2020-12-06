package com.rental.movie.heavymetal.controllers;

import com.rental.movie.heavymetal.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/users"})
        public String getUsers(Model model) {

            model.addAttribute("users", userService.getAll());
            return "users/index";

        }


    }
