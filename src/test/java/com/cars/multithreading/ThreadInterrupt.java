package com.cars.multithreading;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        log.info("Start program");
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                log.info("Waked up");
            } catch (InterruptedException e) {
                log.error("Interrupted {}", Thread.currentThread().getName());
            }
        };
        Thread thread1 = new Thread(task);
        thread1.start();
        log.info("Thread1 started");
        log.info("Sleep 1 sec");
        TimeUnit.SECONDS.sleep(1);
        log.info("Thread1 interrupting...");
        thread1.interrupt();
        log.info("Complete");
    }
}
