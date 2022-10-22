package com.cars.uuid;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class Generator {

    @Test
    public void generate() {
        UUID uuid = UUID.randomUUID();
        log.info("Random UUID: {}", uuid);
    }
}
