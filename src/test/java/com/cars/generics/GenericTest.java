package com.cars.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    public static void main(String[] args) {
        String testString = "TestString";
        String test = getT(testString);
        System.out.println("Test string: " + test);

        Integer number = 55;
        Integer t = getT(number);
        System.out.println("Number: " + t);
    }

    private static <T> T getT(T t) {
        return (T) t;
    }

    @Test
    public void checkRawTypes() {
        List list = new ArrayList();
        list.add("Test");
        list.add(123);
        System.out.println(list);
    }

    @Test
    public void boxTest() {
        Box<String> box = new Box<>();
        box.setBox(new ArrayList<>());
        box.getBox().add("Test");
    }
}
