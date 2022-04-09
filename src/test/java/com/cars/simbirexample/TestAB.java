package com.cars.simbirexample;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TestAB {

    @Test
    void test() {
        C c = new C();
    }

    @Test
    void test2() {
        List<Object> objects = new ArrayList<>();
        log.info("Добавляю объект А");
        objects.add(new A());
        log.info("Добавляю объект В");
        objects.add(new B());
        log.info("Добавляю объект С");
        objects.add(new C());
        A a = (A) objects.get(0);
        B b = (B) objects.get(1);
        C c = (C) objects.get(2);
        log.info("Вызываю метод move() у объекта А");
        a.move();
        log.info("Вызываю метод move() у объекта В");
        b.move();
        log.info("Вызываю метод move() у объекта С");
        c.move();
    }
}
