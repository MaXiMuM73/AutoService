package com.cars.string;

import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

@Log4j2
public class StringReverseTest {
    public static void main(String[] args) {
        log.info("Enter text");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        char[] chars = userInput.toCharArray();
        StringBuilder reverseString = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            reverseString.append(chars[i]);
        }
        log.info("Reverse string: {}", reverseString);
    }
}
