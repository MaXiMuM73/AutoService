package com.cars.multithreading;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.Executor;

@Log4j2
public class ExecutorTest {
    public static void main(String[] args) {
        Executor executor = (runnable) -> new Thread(runnable).start();

        Runnable task = () -> log.info("working");

        executor.execute(task);
    }
}
