package com.rental.movie.heavymetal.utils;

import com.rental.movie.heavymetal.model.*;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class CartSummary {


    public static final BigDecimal BASIC_COST_FOR_ONE_DAY = BigDecimal.valueOf(5);

    public static final BigDecimal IMPACT_ON_THE_PRICE_OF_PREMIERE_MOVIE = BigDecimal.valueOf(3);
    public static final BigDecimal IMPACT_ON_THE_PRICE_OF_NEW_MOVIE = BigDecimal.valueOf(2);
    public static final BigDecimal IMPACT_ON_THE_PRICE_OF_STANDARD_MOVIE = BigDecimal.valueOf(1);
    public static final BigDecimal IMPACT_ON_THE_PRICE_OF_CLASSIC_MOVIE = BigDecimal.valueOf(0.5);

    public static final BigDecimal IMPACT_ON_THE_PRICE_OF_SHORT_TERM_RENTAL = BigDecimal.valueOf(2);
    public static final BigDecimal IMPACT_ON_THE_PRICE_OF_STANDARD_TERM_RENTAL = BigDecimal.valueOf(1);
    public static final BigDecimal IMPACT_ON_THE_PRICE_OF_LONG_TERM_RENTAL = BigDecimal.valueOf(0.5);

    public static final BigDecimal IMPACT_ON_THE_PRICE_OF_SILVER_USERTYPE = BigDecimal.valueOf(0.95);;
    public static final BigDecimal IMPACT_ON_THE_PRICE_OF_GOLD_USERTYPE = BigDecimal.valueOf(0.85);
    public static final BigDecimal IMPACT_ON_THE_PRICE_OF_PLATINUM_USERTYPE = BigDecimal.valueOf(0.7);

    public static final int MAX_DAYS_FOR_SHORT_TERM_RENTAL = 3;
    public static final int MAX_DAYS_FOR_STANDARD_TERM_RENTAL = 6;



/*    public void makeSummary(User user, Cart cart, LocalDate localDate) {
        cart.setCostSummary(BigDecimal.ZERO);
        Map<Copy, Integer> daysOfRentingForCopy = cart.getDaysOfRenting();
        Set<Map.Entry<Copy, Integer>> entrySet = daysOfRentingForCopy.entrySet();
        for (Map.Entry<Copy, Integer> entry : entrySet){
            BigDecimal costSummary = cart.getCostSummary();
            BigDecimal costOfCopy = calculateCostOfCopy(user, entry.getKey(), entry.getValue(), localDate );
            cart.setCostSummary(costSummary.add(costOfCopy));
        }
        }
        */


    public BigDecimal calculateCostOfCopy(User user, Copy copy, int rentalDays, LocalDate rentDate) {
        BigDecimal basicCost = calculateBasicCost(rentalDays);
        BigDecimal impactOfDateRelease = getImpactOfDateRelease(copy.getMovie(), rentDate);
        BigDecimal impactOfUserType = getImpactOfUserType(user);
        return basicCost.multiply(impactOfDateRelease).multiply(impactOfUserType);
    }


    public BigDecimal calculateBasicCostForShortTerm(int days){
        BigDecimal rentalDays = BigDecimal.valueOf(days);
        return BASIC_COST_FOR_ONE_DAY.multiply(rentalDays).multiply(IMPACT_ON_THE_PRICE_OF_SHORT_TERM_RENTAL);
    }

    public BigDecimal calculateBasicCostForStandardTerm(int days) {
            BigDecimal standardTermDays = BigDecimal.valueOf(days - MAX_DAYS_FOR_SHORT_TERM_RENTAL);
            BigDecimal costOfShortTermRental = calculateBasicCostForShortTerm(MAX_DAYS_FOR_SHORT_TERM_RENTAL);
            BigDecimal costOfStandardTermRental = BASIC_COST_FOR_ONE_DAY.multiply(standardTermDays)
                    .multiply(IMPACT_ON_THE_PRICE_OF_STANDARD_TERM_RENTAL);
            return costOfShortTermRental.add(costOfStandardTermRental);
        }

        public BigDecimal calculateBasicCost(int days) {
        if (days <= MAX_DAYS_FOR_SHORT_TERM_RENTAL){
            return calculateBasicCostForShortTerm(days);
        } else if (days <= MAX_DAYS_FOR_STANDARD_TERM_RENTAL) {
            return calculateBasicCostForStandardTerm(days);
        } else {
            int longTermDays = days - MAX_DAYS_FOR_STANDARD_TERM_RENTAL;
           BigDecimal costOfStandardTerm = calculateBasicCostForStandardTerm(MAX_DAYS_FOR_STANDARD_TERM_RENTAL);
            BigDecimal costOfLongTermRental = BASIC_COST_FOR_ONE_DAY.multiply(BigDecimal.valueOf(longTermDays))
                    .multiply(IMPACT_ON_THE_PRICE_OF_LONG_TERM_RENTAL);
            return costOfLongTermRental.add(costOfStandardTerm);
        }
        }


    public BigDecimal getImpactOfDateRelease(Movie movie, LocalDate rentDate){
        int daysFromRelease = howManyDaysPassedFromRelease(movie, rentDate);
        if (daysFromRelease <= 14) {
            return IMPACT_ON_THE_PRICE_OF_PREMIERE_MOVIE;
        } else if (daysFromRelease <= 90) {
            return IMPACT_ON_THE_PRICE_OF_NEW_MOVIE;
        } else if (daysFromRelease <= 365) {
            return IMPACT_ON_THE_PRICE_OF_STANDARD_MOVIE;
        } else {
            return IMPACT_ON_THE_PRICE_OF_CLASSIC_MOVIE;
        }
    }

    public BigDecimal getImpactOfUserType(User user){
        UserType userType = user.getUserType();
        if (userType == UserType.PLATINUM) {
            return IMPACT_ON_THE_PRICE_OF_PLATINUM_USERTYPE;
        } else if (userType == UserType.GOLD) {
            return IMPACT_ON_THE_PRICE_OF_GOLD_USERTYPE;
        } else if (userType == UserType.SILVER) {
            return IMPACT_ON_THE_PRICE_OF_SILVER_USERTYPE;
        } else {
            return BigDecimal.ONE;
        }
    }


    public int howManyDaysPassedFromRelease(Movie movie, LocalDate rentDate) {
        LocalDate releaseDate = movie.getReleaseDate();
        return Period.between(releaseDate, rentDate).getDays();
    }





}
