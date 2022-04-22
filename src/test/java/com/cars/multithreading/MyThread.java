package com.cars.multithreading;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyThread extends Thread {
    @Override
    public void run() {
        log.info("Work");
        throw new RuntimeException("Ошибка в потоке");
    }

    public static void main(String[] args) throws InterruptedException {
        log.info(Thread.currentThread().getName() + " working");
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(5000);
        log.info("Finished");
    }
}
