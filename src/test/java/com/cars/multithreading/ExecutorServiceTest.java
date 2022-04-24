package com.cars.multithreading;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Log4j2
public class ExecutorServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> task = () -> {
            log.info("working callable");
            return Thread.currentThread().getName();
        };
        Runnable taskRunnable = () -> {
            log.info("working runnable");
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            executorService.submit(taskRunnable);
            Future<String> result = executorService.submit(task);
            result.get();
        }

        executorService.shutdown();
        log.info("Finished");
    }
}
