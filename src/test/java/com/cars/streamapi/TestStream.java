package com.cars.streamapi;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

@Log4j2
public class TestStream {

    @Test
    void testReduce() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        Optional<Integer> reduce = integers
                .stream()
                .reduce(Integer::sum);
        log.info("Sum: {}", reduce.get());

        Integer sum = integers
                .stream()
                .reduce(20, Integer::sum);
        log.info(sum);
    }
}
