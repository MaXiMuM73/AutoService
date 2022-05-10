package com.cars.time;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Log4j2
public class TimeZoneTest {

    /**
     * Тестирование времени с часовыми поясами
     */
    @Test
    void timeZoneTest() {
        log.info("Time with timezone test");
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("ECT")));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("Текущее время в Париже: " + formatter.format(now));
    }
}
