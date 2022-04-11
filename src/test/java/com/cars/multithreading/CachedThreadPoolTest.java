package com.cars.multithreading;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Log4j2
public class CachedThreadPoolTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Object lock = new Object();

        Callable<String> task = () -> {
            log.info("working");
            synchronized (lock) {
                lock.wait(1000);
            }
            log.info("Finished");
            return Thread.currentThread().getName();
        };

        ExecutorService executorService = Executors.newCachedThreadPool();

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Future<String> future = executorService.submit(task);
            result.add(future.get());
        }
        result.forEach(log::info);

        executorService.shutdown();
        log.info("Finished main");
    }
}
