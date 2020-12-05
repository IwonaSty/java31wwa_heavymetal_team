package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.Cart;
import com.rental.movie.heavymetal.model.Movie;
import com.rental.movie.heavymetal.model.Order;
import com.rental.movie.heavymetal.services.impl.CartServiceImpl;
import com.rental.movie.heavymetal.services.impl.MovieServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CartServiceImplTest {
    @Autowired
    private CartServiceImpl cartService;

    private static Long expectedId;
    private static Cart cart;
    private static Order order;



    @BeforeAll
    public static void init() {
        expectedId = 1L;
        cart = Cart.builder()
                .order(order)
                .build();
    }

    @Test
    public void cartShouldBeAddedToRepository(){
        //when
        cartService.save(cart);

        Cart cartAdd = cartService.getById(expectedId);
        //then
        assertEquals(cartAdd.getId(), cart.getId());

    }

    @Test
    public void cartShouldBeFindable(){
        //when
        cartService.save(cart);
        Cart addcart = cartService.getById(expectedId);
        //then
        assertEquals(addcart.getId(), cart.getId());
    }

    @Test
    public void cartShouldBeUpdated(){
        //when
        Long updateId = 3L;
        cartService.save(cart);
        Cart cart = cartService.getById(expectedId);
        cart.setId(updateId);
        cartService.update(cart);
        Cart updateCart = cartService.getById(expectedId);
        //then
        assertEquals(updateCart.getId(), cart.getId());

    }

    @Test
    public void cartShouldBeDeleted(){
        //when
        cartService.save(cart);
        cartService.delete(expectedId);
        //then
        Cart gotCart = cartService.getById(expectedId);
        assertNull(gotCart);
    }



}