package com.cars.finaltest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@Log4j2
public class FinalTest {
    private static String string = "test";



    public static void main(String[] args) {
        log.info(string);
        string = "hello";
        log.info(string);
    }

    @Test
    public void testHashCode() {
        Object object = null;
        System.out.println(object.hashCode());
    }

    @Test
    public void restTest() {
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("https://nordwindairlines.ru/ru", String.class, (Object) null);
        String forObject2 = restTemplate.getForObject("https://nordwindairlines.ru//ru", String.class, (Object) null);
        String forObject3 = restTemplate.getForObject("https://nordwindairlines.ru/ru//offers", String.class, (Object) null);
    }

    @Test
    public void testStartWith() {
        String alert = "Предупреждение: статус транзакции ERROR";
        log.info(alert.startsWith("Предупреждение"));
    }
}
