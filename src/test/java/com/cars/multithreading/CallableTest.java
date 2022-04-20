package com.cars.multithreading;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.*;

@Log4j2
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> task = () -> {
            log.info("Working callable task");
            TimeUnit.SECONDS.sleep(3);
            return "Hello world";
        };
        FutureTask<String> futureTask = new FutureTask<>(task);
        new Thread(futureTask).start();

        while (!futureTask.isDone()) {
            Thread.sleep(1000);
            log.info("Task working...");
        }

        log.info("Result of callable task: {}", futureTask.get());
        log.info("Finished");

        Thread thread123 = new Thread();
        thread123.getState();
    }
}
