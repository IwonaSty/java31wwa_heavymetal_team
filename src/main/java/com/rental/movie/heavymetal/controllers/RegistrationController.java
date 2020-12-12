package com.rental.movie.heavymetal.controllers;

import com.rental.movie.heavymetal.model.Role;
import com.rental.movie.heavymetal.model.User;
import com.rental.movie.heavymetal.services.AutoLoginService;
import com.rental.movie.heavymetal.services.RoleService;
import com.rental.movie.heavymetal.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Slf4j
@Controller
public class RegistrationController {
    private final UserService userService;

    private final RoleService roleService;

    private final AutoLoginService autoLoginService;

    public RegistrationController(final UserService userService, final RoleService roleService, final AutoLoginService autoLoginService) {
        this.userService = userService;
        this.roleService = roleService;
        this.autoLoginService = autoLoginService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user",new User());
        return "/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") User user) {

        if (userService.findByEmail(user.getEmail()) != null) {
            log.info("USER exists! " + user.getEmail());

            return "registration";
        }

        Role role = roleService.findByName("USER");

        user.setRoles(Arrays.asList(role));

        userService.save(user);

        log.info("Registered user: " + user.getEmail());

        autoLoginService.autoLogin(user.getEmail(), user.getPassword());

        return "redirect:/client/client-detail"; //TODO zmienić na odpowiedni link

    }

}
