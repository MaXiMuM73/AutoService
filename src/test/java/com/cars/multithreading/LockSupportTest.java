package com.cars.multithreading;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

@Log4j2
public class LockSupportTest {
    @SneakyThrows
    public static void main(String[] args) {
        Runnable task = () -> {
            log.info("Will be parked");
            LockSupport.park();
            log.info("Unparked");
        };

        Thread thread1 = new Thread(task);
        thread1.start();
        TimeUnit.SECONDS.sleep(3);
        log.info("Thread1 state: {}", thread1.getState());
        LockSupport.unpark(thread1);
        TimeUnit.SECONDS.sleep(3);
    }
}
