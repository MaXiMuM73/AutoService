package com.cars.multithreading.readwritelock;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Log4j2
public class ReadWriteLockTest {
    private static final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static final Map<Integer, String> map = new HashMap<>();

    @SneakyThrows
    public static void main(String[] args) {
        Runnable writeTask = () -> {
            readWriteLock.writeLock().lock();
            log.info("Working writer. Waiting 5 seconds...\n");
            try {
                TimeUnit.SECONDS.sleep(5);
                Random random = new Random();
                for (int i = 0; i < 5; i++) {
                    map.put(random.nextInt(), "Test");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readWriteLock.writeLock().unlock();
            }
            log.info("Finished writer");
        };

        Runnable readTask = () -> {
            readWriteLock.readLock().lock();
            log.info("Working reader");
            log.info(map);
            readWriteLock.readLock().unlock();
            log.info("Finished reader");
        };

        new Thread(writeTask).start();
        for (int i = 0; i < 5; i++) {
            log.info("Thread № {} starting", i);
            new Thread(readTask).start();
        }

        new Thread(writeTask).start();
        for (int i = 0; i < 5; i++) {
            log.info("Thread № {} starting", i);
            new Thread(readTask).start();
        }
    }
}
