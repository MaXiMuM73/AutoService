package com.cars.streamapi;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
public class TestStream {

    @Test
    void testReduce() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        Optional<Integer> reduce = integers
                .stream()
                .reduce(Integer::sum);
        log.info("Sum: {}", reduce.get());

        Integer sum = integers
                .stream()
                .reduce(20, Integer::sum);
        log.info(sum);
    }

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

    /**
     * @return collection of integers
     */
    private List<Integer> getIntegers() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(3);
        integerList.add(2);
        integerList.add(4);
        integerList.add(5);
        return integerList;
    }

    /**
     * @return collection of strings
     */
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
}
