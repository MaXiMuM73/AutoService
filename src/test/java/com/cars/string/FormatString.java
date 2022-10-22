package com.cars.string;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FormatString {
    String CLEAR_SPACES_REGEX = "\\s+";

    @Test
    public void clearSpaces() {
        String nonNullString = "Тестовая строка с точкой.";
        String nullString = null;

        String nullResult = getDescription(nullString);
        String nonNullResult = getDescription(nonNullString);
        log.info("Null string: {}",nullResult);
        log.info("Не пустая строка: {}",nonNullResult);
    }

    private String getDescription(String status) {
        return Optional.ofNullable(status)
                .map((this::formatDescription))
                .orElse("");
    }

    private String formatDescription(String description) {
        description = description.replaceAll(CLEAR_SPACES_REGEX, " ").trim();
        if (description.endsWith(".")) description = description.substring(0, description.length() - 1).trim();
        return description;
    }
}
