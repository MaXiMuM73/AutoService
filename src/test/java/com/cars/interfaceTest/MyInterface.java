package com.cars.interfaceTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface MyInterface {
    String string = "Hello world";
    Logger log = LogManager.getLogger(MyInterface.class);

    default void defaultMethod() {
        log.info(string);
    }

    static void staticMethod() {
        log.info("Static method");
    }

    void someMethod();
}
