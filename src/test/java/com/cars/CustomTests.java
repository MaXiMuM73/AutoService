package com.cars;

import com.cars.enums.Day;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CustomTests {



    /**
     * Тестирование Stream API
     */
    @Test
    void streamApiTest() {
        log.info("Stream API test");
        List<String> stringList = getStrings();
        List<Integer> integerList = getIntegers();

        // Тестирование filter
        List<String> filterList = stringList.stream()
                .filter((s -> s.startsWith("test")))
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Filter list " + filterList);

        // Тестирование map
        List<String> peekList = stringList.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Map list " + peekList);

        // Тестирование max
        int max = integerList.stream()
                .mapToInt(a -> a)
                .max()
                .orElse(0);
        System.out.println("Max int: " + max);

        // Тестирование average
        double average = integerList.stream()
                .mapToInt(a -> a)
                .average()
                .orElse(0);
        System.out.println("Average int: " + average);
    }

    private List<Integer> getIntegers() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(3);
        integerList.add(2);
        integerList.add(4);
        integerList.add(5);
        return integerList;
    }

    private List<String> getStrings() {
        List<String> stringList = new ArrayList<>();
        stringList.add("test");
        stringList.add("test1");
        stringList.add("test2");
        stringList.add("test3");
        stringList.add("test4");
        for (int i = 0; i < 10; i++) {
            String randomString = RandomStringUtils.randomAlphabetic(5);
            stringList.add(randomString);
        }
        return stringList;
    }

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

    /**
     * Перевернуть строку
     */
    @Test
    void reverseString() {
        String input = "Hello world, Java";
        char[] chars = input.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            stringBuilder.append(chars[i]);
        }
        System.out.println(input);
        System.out.println(stringBuilder);
    }
}
