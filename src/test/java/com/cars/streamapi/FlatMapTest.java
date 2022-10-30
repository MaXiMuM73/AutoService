package com.cars.streamapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class FlatMapTest {

    @Test
    public void notFlatMapImpl() {
        List<Human> humans = getHumans();

        List<String> petNames = new ArrayList<>();
        for (Human human : humans) {
            petNames.addAll(human.getPets());
        }

        log.info(petNames.toString());
    }

    @Test
    public void flatMapImpl() {
        List<Human> humans = getHumans();

        List<String> petNames = humans.stream()
                .map(Human::getPets) //преобразовываем Stream<Human> в Stream<List<Pet>>
                .flatMap(Collection::stream) //"разворачиваем" Stream<List<Pet>> в Stream<Pet>
                .collect(Collectors.toList());

        log.info(petNames.toString());
    }

    private List<Human> getHumans() {
        return asList(
                new Human("Sam", asList("Buddy", "Lucy")),
                new Human("Bob", asList("Frankie", "Rosie")),
                new Human("Marta", asList("Simba", "Tilly")));
    }

    @SafeVarargs
    private <T> List<T> asList(T... elements) {
        return List.of(elements);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private static class Human {
        String name;
        List<String> pets;
    }
}
