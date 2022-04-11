package com.cars.multithreading;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.*;

@Log4j2
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> task = () -> {
            log.info("working");
            TimeUnit.SECONDS.sleep(3);
            return "Hello world";
        };
        FutureTask<String> futureTask = new FutureTask<>(task);
        new Thread(futureTask).start();
        log.info(futureTask.get());

        log.info("working");
    }
}
