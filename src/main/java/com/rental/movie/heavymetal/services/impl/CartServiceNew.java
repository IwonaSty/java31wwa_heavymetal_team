package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.Copy;
import com.rental.movie.heavymetal.model.Order;
import com.rental.movie.heavymetal.model.User;
import com.rental.movie.heavymetal.repositories.CopyRepository;
import com.rental.movie.heavymetal.repositories.OrderRepository;
import com.rental.movie.heavymetal.repositories.UserRepository;
import com.rental.movie.heavymetal.utils.CartSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.swing.*;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
@RequiredArgsConstructor
public class CartServiceNew {

    private final CopyRepository copyRepository;
    private final CartSummary cartSummary;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    private Map<Copy, Integer> copiesWithRentalDays = new HashMap<>();
    private BigDecimal totalCost = BigDecimal.ZERO;
    private LocalDate rentalDate = LocalDate.now();


    public void addCopy(User user, Copy copy, Integer rentalDays) throws Exception {
        if (copiesWithRentalDays.containsKey(copy)) {
            throw new Exception();
        } else {
            copiesWithRentalDays.put(copy, rentalDays);
            makeCartSummary(user);
        }
    }


    public void removeCopy(User user, Copy copy) throws Exception {
        if (copiesWithRentalDays.containsKey(copy)) {
            copiesWithRentalDays.remove(copy);
            makeCartSummary(user);
        } else {
            throw new Exception();
        }
    }


    public Map<Copy, Integer> getCopiesFromCart() {
        return Collections.unmodifiableMap(copiesWithRentalDays);
    }


    public void makeCartSummary(User user){
        Set<Map.Entry<Copy, Integer>> entrySet = copiesWithRentalDays.entrySet();
        for (Map.Entry<Copy, Integer> entry : entrySet){
            BigDecimal costOfCopy = cartSummary.calculateCostOfCopy(user, entry.getKey(), entry.getValue(), rentalDate );
            totalCost = totalCost.add(costOfCopy);
        }
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void order (User user){
        Order newOrder = new Order();
        newOrder.setOrderDate(rentalDate);
        newOrder.setUser(user);
        //TODO - order probably should have Collections with Copies
        orderRepository.save(newOrder);
        userRepository.save(user);
        clearCart();
        SecurityContextHolder.getContext().getAuthentication().getName();
    }


    private void clearCart(){
        copiesWithRentalDays.clear();
        totalCost = BigDecimal.ZERO;
    }






}
