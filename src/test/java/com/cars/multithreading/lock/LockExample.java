package com.cars.multithreading.lock;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Log4j2
public class LockExample implements Runnable {
    private final Resource resource;
    private final Lock lock;

    public LockExample(Resource resource) {
        this.resource = resource;
        lock = new ReentrantLock();
    }

    @Override
    public void run() {
        try {
            // Попытка получить лок и выполнить синхронизированно метод doSomething()
            if (lock.tryLock(10, TimeUnit.SECONDS)) resource.doSomething();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            lock.unlock();
        }
        // Логирование без синхронизации
        resource.doLogging();
    }
}
