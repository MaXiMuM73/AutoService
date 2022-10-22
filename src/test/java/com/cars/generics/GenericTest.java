package com.cars.generics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class GenericTest {

    public static void main(String[] args) {
        String testString = "TestString";
        String test = getT(testString);
        System.out.println("Test string: " + test);

        Integer number = 55;
        Integer t = getT(number);
        System.out.println("Number: " + t);
    }

    private static <T> T getT(T t) {
        return (T) t;
    }

    @Test
    public void checkRawTypes() {
        List list = new ArrayList();
        list.add("Test");
        list.add(123);
        System.out.println(list);
    }

    @Test
    public void boxTest() {
        Box<String> box = new Box<>();
        box.setBox(new ArrayList<>());
        box.getBox().add("Test");

    }

    @Test
    public void typeErasure() {
        List<String> strings = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        System.out.println(strings.getClass() == numbers.getClass());
    }

    @Test
    public void testClass() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> stringClass = Class.forName("java.lang.String");
        Constructor<?> stringConstructor = stringClass.getConstructor(String.class);
        String string = (String) stringConstructor.newInstance("Test");
        log.info("String: {} Class: {}", string, string.getClass().getSimpleName());

        Class<?> integerClass = Class.forName("java.lang.Integer");
        Constructor<?> integerConstructor = integerClass.getConstructor(Integer.class);
        Integer number = (Integer) integerConstructor.newInstance();
        log.info("Number: {} Class: {}", number, number.getClass().getSimpleName());
    }

    @Test
    public void customTest() {
        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        List<? super Integer> nums = ints;
        nums.add(35); // compile-time error
    }
}
