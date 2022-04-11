package com.cars.multithreading;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.concurrent.*;

@Log4j2
public class ExecutorServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> task = () -> {
            log.info("working");
            return Thread.currentThread().getName();
        };
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            Future<String> result = executorService.submit(task);
            result.get();
        }
        executorService.shutdown();
        log.info("Finished");
    }
}