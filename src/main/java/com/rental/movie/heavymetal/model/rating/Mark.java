package com.rental.movie.heavymetal.model.rating;

public enum Mark {
    VERY_BAD(1),
    BAD(2),
    AVERAGE(3),
    GOOD(4),
    SUPER(5);
    private int description_number;

    Mark(int description_number) {
        this.description_number = description_number;
    }
}
