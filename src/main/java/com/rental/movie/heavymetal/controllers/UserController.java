package com.rental.movie.heavymetal.controllers;

import com.rental.movie.heavymetal.model.User;
import com.rental.movie.heavymetal.repositories.UserRepository;
import com.rental.movie.heavymetal.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestMapping(value="/user/delete")
    public String deleteUser(@RequestParam Long id , Model model) {

            userService.delete(id);
            return "redirect:/users";

    }


    }
