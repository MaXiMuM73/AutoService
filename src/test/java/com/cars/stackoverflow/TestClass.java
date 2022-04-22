package com.cars.stackoverflow;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Optional;

/**
 * StackOverFlow example
 */
@Log4j2
public class TestClass {

    InnerClass innerClass;

    public TestClass() {
        innerClass = new InnerClass();
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        Optional<Integer> reduce = integers.stream().reduce((x, y) -> x * y);
    }

    static class InnerClass {
//        TestClass testClass = new TestClass();
    }
}
