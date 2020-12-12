package com.rental.movie.heavymetal.model;

import lombok.NoArgsConstructor;

public enum UserType {
    SILVER("Silver"), GOLD("Gold"), PLATINUM("Platinum");

    private String name;

    UserType(String name) {
        this.name = name;
    }
}
