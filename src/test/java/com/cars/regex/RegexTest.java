package com.cars.regex;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class RegexTest {

    @Test
    public void testRegex() {
        String str = "TestXaXaXoxoX";
        String newStr = str.replaceAll("[Xx][ao]", "|REPLACED|");

        log.info("Исходная строка: {}", str);

        log.info("String: {}", newStr);

        String deleteTest = str.replaceAll("[^Xx]", "");
        log.info("String: {}", deleteTest);
    }
}
