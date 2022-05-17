package com.cars.stackoverflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OOMExample {
    public static void main(String[] args) {
        List<Integer> collection = new ArrayList<>();
        Random random = new Random();

        while (true) {
            Integer number = random.nextInt();
            collection.add(number);
        }
    }
}
