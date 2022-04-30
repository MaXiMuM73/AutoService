package com.cars.interfaceTest;

public class MyClass implements MyInterface {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.defaultMethod();
        MyInterface.staticMethod();
    }

    @Override
    public void defaultMethod() {
        System.out.println("Default method override");
    }
}
