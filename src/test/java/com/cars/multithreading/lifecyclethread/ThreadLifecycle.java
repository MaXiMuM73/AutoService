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

        for (int i = 0; i < 5; i++) {
            new Thread(task).start();
        }

        log.info("Main finished");
    }
}
