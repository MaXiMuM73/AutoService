package com.cars.string;

import org.junit.jupiter.api.Test;

public class StringReverseTest {

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
