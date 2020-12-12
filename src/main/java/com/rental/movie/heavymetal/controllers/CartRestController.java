package com.rental.movie.heavymetal.controllers;

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

    @PostMapping()
    public void addCopyToCart(@RequestBody final int days){
       // cartService.addCopy(); user, copy, int
    }

    @DeleteMapping
    public void removeCopyFromCart(){

    }

    @GetMapping
    public void makeAnOrder(){

    }








}
