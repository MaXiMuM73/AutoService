package com.cars.collection;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class CollectionCompare {

    private List<Integer> getOne() {
        return new ArrayList<>(List.of(1, 2, 3, 4, 5, 7, 11));
    }

    private List<Integer> getTwo() {
        return new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 8, 22, 77));
    }

    @Test
    void test() {
        List<Integer> one = getOne();
        List<Integer> two = getTwo();

        List<Integer> newIds = one
                .stream()
                .filter(id -> !two.contains(id))
                .collect(Collectors.toList());

        List<Integer> removeIds = two
                .stream()
                .filter(id -> !one.contains(id))
                .collect(Collectors.toList());

        log.info(newIds);
        log.info(removeIds);
    }
}
