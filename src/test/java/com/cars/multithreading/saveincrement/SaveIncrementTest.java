package com.cars.multithreading.saveincrement;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Log4j2
public class SaveIncrementTest {
    private static final AtomicLong count = new AtomicLong(0);
    private static final Lock lock = new ReentrantLock();
    private static final Semaphore semaphore = new Semaphore(5);


    public static void main(String[] args) throws InterruptedException {
        Runnable incrementTask = () -> {
            lock.lock();
            log.info(Thread.currentThread().getName() + " working");
            for (int i = 0; i < 1000000; i++) {
                count.incrementAndGet();
            }
            log.info(Thread.currentThread().getName() + ": {}", count);
            lock.unlock();
        };

        for (int i = 0; i < 10; i++) {
            new Thread(incrementTask).start();
        }
    }
}
