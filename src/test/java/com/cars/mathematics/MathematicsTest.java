package com.cars.mathematics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
public class MathematicsTest {

    @Test
    void sumOfDouble() {
        double a = 181890.2;
        log.info("Число а = {}", a);
        double b = 57872.85;
        log.info("Число b = {}", b);
        double sum = a + b;
        log.info("Сумма а и b = {}", sum);

        System.out.println("\n");

        double a100 = a * 100;
        log.info("a100 = {}", a100);
        double b100 = b * 100;
        log.info("b100 = {}", b100);
        double sum100 = a100 + b100;
        log.info("Сумма а100 и b100 = {}", sum100);
        log.info("Сумма а100 и b100, деленная на 100 = {}", sum100 / 100);
    }
}
