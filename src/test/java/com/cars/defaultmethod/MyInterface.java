package com.cars.defaultmethod;

public interface MyInterface {
    default void myMethod() {
        System.out.println("My method");
    }
}
