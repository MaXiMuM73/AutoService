package com.cars.compareLong;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class LongCompareTest {

    @Test
    void compareLongTest() {
        Long one = 185L;
        Long two = new Long(185L);
        log.info(one.equals(two));
    }

    @Test
    void testCollectionOfLong() {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(100L);
        list.add(200L);
        list.add(300L);
        list.add(400L);

        List<Long> list2 = new ArrayList<>();
        list2.add(1L);
        list2.add(100L);
        list2.add(200L);

        List<Long> newIds = list
                .parallelStream()
                .filter(id -> !list2.contains(id))
                .collect(Collectors.toList());

        log.info(newIds);
    }
}
