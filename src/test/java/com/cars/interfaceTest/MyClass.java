package com.cars.interfaceTest;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyClass implements MyInterface {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.defaultMethod();
        MyInterface.staticMethod();
    }

    @Override
    public void someMethod() {
        System.out.println("Some method");
    }
}
