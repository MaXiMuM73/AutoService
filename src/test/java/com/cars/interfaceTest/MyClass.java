package com.cars.interfaceTest;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyClass extends ParentClass implements MyInterface {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.defaultMethod();
        MyInterface.staticMethod();
        myClass.parentMethod();
    }

    public MyClass() {
        log.info("MyClass constructor");
    }

    @Override
    public void someMethod() {
        log.info("Some method");
    }

    @Override
    public void someMethodTwo() {
        log.info("Some method two");
    }
}
