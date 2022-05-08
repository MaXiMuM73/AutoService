package com.cars.ionio;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Log4j2
public class IoTest {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss.SSS");
    private static FileWriter fileWriter;

    static {
        try {
            fileWriter = new FileWriter("./test.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new MyThreadWriter()).start();
            String now = LocalDateTime.now().format(dateTimeFormatter);
            fileWriter.write(now + " " + Thread.currentThread().getName() + " Test " + i + "\n");
        }
        Thread.sleep(2000);
        fileWriter.close();
    }

    static class MyThreadWriter implements Runnable {
        @SneakyThrows
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                String now = LocalDateTime.now().format(dateTimeFormatter);
                fileWriter.write(now + " " + Thread.currentThread().getName() + " Test " + i + "\n");
            }
        }
    }

}
