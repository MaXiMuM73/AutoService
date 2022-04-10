package com.cars.multithreading;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.TimeUnit;

/**
 * Wait и ожидание по монитору. Методы notify и notifyAll
 */
@Log4j2
public class LockWait {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Runnable task = () -> {
            synchronized (lock) {
                try {
                    log.info("Waiting...");
                    lock.wait();
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("Thread1 finished");
            }
        };

        Thread thread1 = new Thread(task);
        thread1.start();

        TimeUnit.SECONDS.sleep(3);
        log.info("Main get lock and notify");
        synchronized (lock) {
            lock.notify();
        }
        log.info("Main finished");
    }
}
