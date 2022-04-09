package com.cars.collection;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@Log4j2
public class CollectionTests {

    @Test
    public void collectionSync() throws InterruptedException {
        long now = System.currentTimeMillis();

        List<Integer> list = new CopyOnWriteArrayList<>();

        Thread thread1 = new Thread(() -> {
            System.out.println("Работает поток 1 ");
            Random r = new Random();
            int i;
            int next = 0;
            while (next < 1000000) {
                i = r.nextInt();
                list.add(i);
                next++;
            }
            log.info("Поток 1 работу закончил");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Работает поток 2");
            Random r = new Random();
            int i;
            int next = 0;
            while (next < 1000000) {
                i = r.nextInt();
                list.add(i);
                next++;
            }
            log.info("Поток 2 работу закончил");
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        long end = System.currentTimeMillis();
        double result = (double) (end - now) / 1000;
        log.info("Time spent: {} с", result);
        log.info("Count of elements: {}", list.size());

    }
}
