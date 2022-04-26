package com.cars.multithreading.saveincrement;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class RaceCondition {
    public static Long value = 0L;

    @SneakyThrows
    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 1000000; i++) {
//                int oldValue = value;
//                int newValue = ++value;
//                if (oldValue + 1 != newValue) {
//                    throw new IllegalStateException(oldValue + " + 1 = " + newValue);
//                }
                value++;
            }
        };
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        Thread.sleep(2000);
        log.info(value);
    }
}
