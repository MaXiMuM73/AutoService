package com.cars.finaltest;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class FinalTest {
    private static String string = "test";

    public static void main(String[] args) {
        log.info(string);
        string = "hello";
        log.info(string);
    }
}
