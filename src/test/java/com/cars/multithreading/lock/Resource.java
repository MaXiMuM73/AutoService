package com.cars.multithreading.lock;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Resource {

    public void doSomething() {
        log.info("Do something");
    }

    public void doLogging() {
        log.info("Logging");
    }
}
