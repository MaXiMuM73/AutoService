package com.cars.multithreading;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.TimeUnit;

@Log4j2
public class Monitor {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Runnable task = () -> {
            synchronized (lock) {
                log.info("Task");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(task);
        thread.start();

        synchronized (lock) {
            for (int i = 0; i < 5; i++) {
                TimeUnit.SECONDS.sleep(1);
                log.info("Spent {} sec", i + 1);
            }
        }
        thread.join();
        log.info("Finished");
    }
}
