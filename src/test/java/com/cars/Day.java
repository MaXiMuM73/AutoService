package com.cars;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Day {
    MONDAY("Понедельник", 1),
    TUESDAY("Вторник", 2);

    private final String name;
    private final Integer number;
}
