package com.cars.multithreading;

import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

@Log4j2
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        int threadBound = 2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, threadBound, 0L,
                TimeUnit.SECONDS, new SynchronousQueue<>());
        threadPoolExecutor.setRejectedExecutionHandler((runnable, executor) -> System.out.println("Rejected"));

        Callable<String> task = () -> {
            log.info("working");
            Thread.sleep(1000);
            return Thread.currentThread().getName();
        };
        for (int i = 0; i < threadBound; i++) {
            threadPoolExecutor.submit(task);
        }

        log.info("Finished");
        threadPoolExecutor.shutdown();
    }
}
