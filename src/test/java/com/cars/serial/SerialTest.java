package com.cars.serial;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class SerialTest {
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
}
