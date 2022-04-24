package com.cars.multithreading.saveincrement;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class IncrementWithLockOnObject {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Runnable incrementTask = () -> {
            synchronized (counter) {
                String threadName = Thread.currentThread().getName();
                log.info(threadName + " working");
                for (int i = 0; i < 10; i++) {
                    counter.increment();
                }
                log.info(threadName + " finished. Count: {}", counter.count);
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(incrementTask).start();
        }
    }

    public static class Counter {
        private int count;

        public void increment() {
            count++;
        }
    }
}
