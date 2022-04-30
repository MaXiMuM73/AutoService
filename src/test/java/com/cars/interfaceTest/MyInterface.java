package com.cars.interfaceTest;

public interface MyInterface {
    String string = "Hello world";

    default void defaultMethod() {
        System.out.println(string);
    }

    static void staticMethod() {
        System.out.println("Static method");
    }
}
