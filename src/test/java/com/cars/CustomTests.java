package com.cars;

import com.cars.serial.Person;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CustomTests {

    /**
     * Тестирование Enumerated
     */
    @Test
    void enumTest() {
        log.info("Enumerated test");
        Day monday = Day.TUESDAY;
        System.out.println(monday.getName());
        System.out.println(monday.getNumber());
    }

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

    /**
     * Сериализация
     */
    @Test
    void serial() {
        Person[] people = {
                new Person(1, "Ivan"),
                new Person(2, "Petr"),
                new Person(3, "Vladimir")
        };

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("people.bin"))) {
            oos.writeObject(people);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Десериализация
     */
    @Test
    void deSerial() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("people.bin"))) {
            Person[] people = (Person[]) ois.readObject();
            System.out.println("Person count: " + people.length);
            Arrays.stream(people).forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

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
