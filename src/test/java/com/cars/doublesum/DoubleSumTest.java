package com.cars.doublesum;

import java.math.BigDecimal;
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

    @Test
    public void bigDecimalSum() {
        BigDecimal number = new BigDecimal("0.1");
        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < 100000; i++) {
            sum=sum.add(number);
        }
        log.info("Сумма = {}", sum);
    }
}
