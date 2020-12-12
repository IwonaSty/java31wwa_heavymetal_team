package com.rental.movie.heavymetal.model;

public enum Genre {

    DOCUMENTARY("Documentary"),
    HORROR("Horror"),
    SCI_FI("Sci-fi"),
    FANTASY("Fantasy"),
    CARTOON("Cartoon"),
    ACTION("Action"),
    COMEDY("Comedy"),
    DRAMA("Drama"),
    WESTERN("Western"),
    ADVENTURE ("Adventure");

    private String name;

    Genre(String name) {
        this.name = name;
    }
}
