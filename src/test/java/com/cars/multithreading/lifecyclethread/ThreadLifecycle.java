package com.cars.multithreading.lifecyclethread;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ThreadLifecycle {

    public static void main(String[] args) {
        Runnable task = () -> {
            log.info("Task processing");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("Task complete");
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        Thread thread4 = new Thread(task);
        Thread thread5 = new Thread(task);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        log.info("Working while true");
        while (true) {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread1 = new Thread(task);
            thread2 = new Thread(task);
            thread3 = new Thread(task);
            thread4 = new Thread(task);
            thread5 = new Thread(task);

            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();

            break;
        }
    }
}
