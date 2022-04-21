package com.cars.stackoverflow;

/**
 * StackOverFlow example
 */
public class TestClass {

    InnerClass innerClass;

    public TestClass() {
        innerClass = new InnerClass();
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
    }

    static class InnerClass {
        TestClass testClass = new TestClass();
    }
}
