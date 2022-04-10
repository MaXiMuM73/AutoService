package com.cars.multithreading;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Log4j2
public class ReentrantLockTest {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();

        Runnable task = () -> {
          lock.lock();
          log.info("Locked");
          log.info("Working 3 sec");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
          log.info("Unlocked");
        };

        lock.lock();
        log.info("Locked");

        Thread thread = new Thread(task);
        thread.start();

        log.info("Main working 3 sec");
        TimeUnit.SECONDS.sleep(3);
        log.info("Finished");
        lock.unlock();
        log.info("Unlocked");
    }
}
