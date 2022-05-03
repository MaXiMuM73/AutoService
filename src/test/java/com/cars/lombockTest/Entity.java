package com.cars.lombockTest;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Entity {
    private String name;

    public static void main(String[] args) {
        Entity entity = new Entity();
    }
}
