package com.rental.movie.heavymetal.controllers;

import com.rental.movie.heavymetal.model.*;
import com.rental.movie.heavymetal.services.MovieService;
import com.rental.movie.heavymetal.services.impl.CartServiceNew;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;


@Controller
@Slf4j
public class CartController {

    private final MovieService movieService;

    private final CartServiceNew cartServiceNew;


    public CartController(MovieService movieService, final CartServiceNew cartServiceNew) {
        this.movieService = movieService;
        this.cartServiceNew = cartServiceNew;
    }


    @GetMapping("/cart-summary")
    public String showCart(Model model, @AuthenticationPrincipal User user) {
        cartServiceNew.setCurrentUser(user);
        model.addAttribute("total", cartServiceNew.getTotalCost());
        Map<Copy,Integer> copiesWithRenatalDays = cartServiceNew.getCopiesFromCart();
        Set<Copy> copies = copiesWithRenatalDays.keySet();
        model.addAttribute("copies",copies);
        return "cart/cart-summary";
    }

    @PostMapping("/cart-summary")
    public String saveMovie(@ModelAttribute Order order) {
    //    cartServiceNew.newOrder();
        log.info("Your order has been confirmed: " + order);

        return "redirect:/movies";
    }

    @RequestMapping(value="/copies/delete")
    public String deleteMovie(@RequestParam Long id , Model model) {

    //    cartServiceNew.removeCopy(id);
        return "redirect:/movies/action";

    }


    @GetMapping("/movies/addToBasket")
    public String getOneWorker(@RequestParam Long id, Model model, @AuthenticationPrincipal User user) throws Exception {
        cartServiceNew.setCurrentUser(user);
        Movie movie = movieService.getById(id);

        cartServiceNew.addMovie(movie,2);

        return "index";

    }

}
