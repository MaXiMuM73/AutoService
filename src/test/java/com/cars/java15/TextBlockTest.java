package com.cars.java15;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TextBlockTest {
    public static void main(String[] args) {
        String TEXT_BLOCK_JSON = """
                {
                    "name" : "someName",
                    "site" : "https://www.someSite.com/"
                }
                """;
        log.info(TEXT_BLOCK_JSON);
    }
}
