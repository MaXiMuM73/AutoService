package com.cars.multithreading;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.TimeUnit;

/**
 * Thread.join() — ожидание завершения другого потока
 */
@Log4j2
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            log.info("Task");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(task);
        log.info("Thread start");
        thread.start();
        thread.join();
        log.info("Finished");
    }
}
