package com.cars.enums;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
public class EnumTest {
    /**
     * Тестирование Enumerated
     */
    @Test
    void enumTest() {
        log.info("Enumerated test");
        Day monday = Day.TUESDAY;
        log.info(monday.getName());
        log.info(monday.getNumber());
    }
}
