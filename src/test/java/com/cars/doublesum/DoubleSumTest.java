package com.cars.doublesum;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
public class DoubleSumTest {

    @Test
    public void sum() {
        double number = 0.1;
        double sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += number;
        }
        log.info("Сумма = {}", sum);
    }
}
