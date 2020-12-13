package com.rental.movie.heavymetal.controllers;

import com.rental.movie.heavymetal.model.Copy;
import com.rental.movie.heavymetal.model.Movie;
import com.rental.movie.heavymetal.services.impl.CartServiceNew;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CartRestController {

    private final CartServiceNew cartService;

    @GetMapping("/shoppingCart")
    public CartServiceNew getCart(){
        return cartService;
    }


/*    @PostMapping("/shoppingCart")
    public void addCopyToCart(@RequestBody Copy copy){
        try {
            cartService.addCopy(copy, 1);
        } catch (Exception e) {
            System.out.println("Copy is not available");
        }
    }*/


    @PostMapping("/shoppingCart")
    public void addMovieToCart(@RequestBody Movie movie){
        try {
            cartService.addMovie(movie, 1);
        } catch (Exception e) {
            System.out.println("Movie is not available");
        }
    }

    @DeleteMapping("/shoppingCart")
    public void removeCopyFromCart(@RequestBody Copy copy){
       try {
           cartService.removeCopy(copy);
       } catch (Exception e) {
           System.out.println("There is no such copy.");
       }

    }

    @GetMapping("/order")
    public void makeAnOrder(){
        cartService.order();
    }








}
