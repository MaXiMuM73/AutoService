package com.cars.wildcards;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class WildCardsTest {

    /**
     * Producer Extends Consumer Super.
     */
    @Test
    public void test() {
        List<Class3> class3List = new ArrayList<>();
        class3List.add(new Class3());

        List<Class4> class4List = new ArrayList<>();
        class4List.add(new Class4());

        List<Class2> class2List = new ArrayList<>();
        class2List.add(new Class2());

//        addElementToProducer(class3List);
        addElementToProducer(class4List);
    }

    private void addElementToProducer(List<? extends Class3> list) {
        list.forEach((e) -> log.info(e.getClass().getSimpleName()));
        List<Class3> class3List = new ArrayList<>(list);
        class3List.forEach((e) -> System.out.println(e.getClass().getName()));

        Class1 class1 = list.get(0);
        Class2 class2 = list.get(0);
        Class3 class3 = list.get(0);

        System.out.println(class1.getClass().getSimpleName());

        Class4 class4 = (Class4) list.get(0);
        if (class3 instanceof Class4) {
            Class4 class44 = (Class4) list.get(0);
            log.info("Instanceof Method list.get(0) {}", class4.getClass().getSimpleName());
        }

        log.info("Method list.get(0) {}", class3.getClass().getSimpleName());
    }

    private void addElementToConsumer(List<? super Class3> list) {
        list.add(new Class3());
        list.add(new Class4());
    }
}
