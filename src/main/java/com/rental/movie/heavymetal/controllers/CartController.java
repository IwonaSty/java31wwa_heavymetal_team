package com.rental.movie.heavymetal.controllers;

import com.rental.movie.heavymetal.model.*;
import com.rental.movie.heavymetal.services.impl.CartServiceNew;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Controller
@Slf4j
public class CartController {

    private final CartServiceNew cartServiceNew;


    public CartController(final CartServiceNew cartServiceNew) {
        this.cartServiceNew = cartServiceNew;
    }


    @GetMapping("/cart-summary")
    public String showCart(Model model) {
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

}
