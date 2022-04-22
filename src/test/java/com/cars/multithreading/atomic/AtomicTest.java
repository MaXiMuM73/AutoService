package com.cars.multithreading.atomic;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.atomic.AtomicInteger;

@Log4j2
public class AtomicTest {
    private static final AtomicInteger count = new AtomicInteger(0);

    @SneakyThrows
    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                count.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " count = " + count);
            }
            System.out.println(Thread.currentThread().getName() + " Final count = " + count);
        };

        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();

        Thread.sleep(1000);
        log.info("Final: {}", count);
    }
}
