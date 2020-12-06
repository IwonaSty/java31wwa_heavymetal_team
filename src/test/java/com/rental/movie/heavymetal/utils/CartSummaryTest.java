package com.rental.movie.heavymetal.utils;

import com.rental.movie.heavymetal.model.*;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartSummaryTest {

    @Autowired
    private CartSummary cartSummary;


    @Test
    void shouldGiveImpactOfDatesReleases(){
        //given
        Movie movie = Movie.builder().releaseDate(LocalDate.of(2020, 1, 1)).build();
        LocalDate rentDate = LocalDate.of(2020, 1, 10);
        //when
        BigDecimal result = cartSummary.getImpactOfDateRelease(movie, rentDate);
        //then
        BigDecimal expected = CartSummary.IMPACT_ON_THE_PRICE_OF_PREMIERE_MOVIE;
        assertEquals(expected, result);
    }


    @Test
    void shouldGiveImpactOfUsersTypes(){
        //given
        User user = User.builder().userType(UserType.SILVER).build();
        //when
        BigDecimal result = cartSummary.getImpactOfUserType(user);
        //then
        BigDecimal expected = CartSummary.IMPACT_ON_THE_PRICE_OF_SILVER_USERTYPE;
        assertEquals(expected, result);
    }


    @Test
    void shouldCalculatehowManyDaysPassedFromRelease(){
        //given
        Movie movie = Movie.builder().releaseDate(LocalDate.of(2020, 1, 1)).build();
        LocalDate rentDate = LocalDate.of(2020, 1, 10);
        //when
        int result = cartSummary.howManyDaysPassedFromRelease(movie, rentDate);
        //then
        int expected = 9;
        assertEquals(expected, result);
    }


    @Test
    public void shouldCalculateBasicCostForShortTerm(){
        //given
        int rentalDays = 2;
        //when
       BigDecimal result = cartSummary.calculateBasicCostForShortTerm(rentalDays);
       BigDecimal expected = BigDecimal.valueOf(20); // rental days * impactOfRelays * basic coste = 2 * 2 * 5
        //then
        assertEquals(expected, result);
    }

    @Test
    public void shouldCalculateBasicCostForShortTermWithBasicMethod(){
        //given
        int rentalDays = 2;
        //when
        BigDecimal result = cartSummary.calculateBasicCost(rentalDays);
        BigDecimal expected = BigDecimal.valueOf(20); // rental days * impactOfRelays * basic coste = 2 * 2 * 5
        //then
        assertEquals(expected, result);
    }

    @Test
    public void shouldCalculateBasicCostForStandardTerm(){
        //given
        int rentalDays = 5;
        //when
        BigDecimal result = cartSummary.calculateBasicCostForStandardTerm(rentalDays);
        BigDecimal expected = BigDecimal.valueOf(40); // 3 * 2 * 5 + 2 * 1 * 5
    //then
        assertEquals(expected, result);
    }

    @Test
    public void shouldCalculateBasicCostForStandardTermWithBasicMethod(){
        //given
        int rentalDays = 5;
        //when
        BigDecimal result = cartSummary.calculateBasicCost(rentalDays);
        BigDecimal expected = BigDecimal.valueOf(40); // 3 * 2 * 5 + 2 * 1 * 5
        //then
        assertEquals(expected, result);
    }

    @Test
    public void shouldCalculateBasicCostForLongTermWithBasicMethod(){
        //given
        int rentalDays = 8;
        //when
        BigDecimal result = cartSummary.calculateBasicCost(rentalDays);
        BigDecimal expected = BigDecimal.valueOf(50.0); // 3 * 2 * 5 + 3 * 1 * 5 + 2 * 0.5 * 5 = 30 + 15 + 5
        //then
        assertEquals(expected, result);
    }

    @Test
    public void shouldCalculateCostOfCopyOfPremiereMovieForPlatinumUser(){
        //given
        User user = User.builder().userType(UserType.PLATINUM).build();
        Movie movie = Movie.builder().releaseDate(LocalDate.of(2020, 1, 1)).build();
        Copy copy = Copy.builder().movie(movie).build();
        LocalDate rentDate = LocalDate.of(2020, 1, 10);
        int rentalDays = 8;
        //when
        int resultInInt = cartSummary.calculateCostOfCopy(user, copy, rentalDays, rentDate).intValue();
        //then
        int expectedInInt = 105; // 50 * 3 * 0.7
        assertEquals(expectedInInt, resultInInt); //int Value becouse in Big Decimal Expected was 105.0 and Actual:105.00
    }

    @Test
    public void shouldMakeCartSummary(){
        //given
        User user = User.builder().userType(UserType.PLATINUM).build();
        Movie movie = Movie.builder().releaseDate(LocalDate.of(2020, 1, 1)).build();
        Copy copy = Copy.builder().movie(movie).build();
        LocalDate rentDate = LocalDate.of(2020, 1, 10);
        int rentalDays = 8;
        Cart cart = new Cart();
        Map<Copy, Integer> map = new HashMap<>();
        cart.setDaysOfRenting(map);
        cart.getDaysOfRenting().put(copy, rentalDays);
        //when
        cartSummary.makeSummary(user, cart, rentDate);
        int resultInInt = cart.getCostSummary().intValue();
        //then
        int expectedInInt = 105; // 50 * 3 * 0.7
        assertEquals(expectedInInt, resultInInt); //int Value becouse in Big Decimal Expected was 105.0 and Actual:105.00
    }




    }










