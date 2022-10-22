package com.cars.mathematics;

import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class Money {

    @Test
    public void test() {
        BigDecimal money = new BigDecimal("100.25");
        log.info("Balance: {}", money);
        long longMoney = money.longValue();
        log.info("Long balance: {}", longMoney);
    }
}
