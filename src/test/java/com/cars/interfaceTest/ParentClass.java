package com.cars.interfaceTest;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ParentClass {

    public ParentClass() {
        log.info("Parent constructor");
    }

    protected void parentMethod() {
        log.info("Parent method");
    }
}
