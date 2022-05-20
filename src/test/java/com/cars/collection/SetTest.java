package com.cars.collection;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

@Log4j2
public class SetTest {

    @Test
    void testAddAll() {
        Set<Long> ids = new HashSet<>();
        Set<Long> ids2 = new HashSet<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(4L);
        ids2.add(1L);
        ids2.add(2L);
        ids2.add(3L);
        boolean b = ids.addAll(ids2);
        System.out.println(b);
        System.out.println(ids);
    }
}
