package com.cars.encrypt;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class Encrypt {

    // String base64 = Base64.getEncoder().encodeToString(privateDateDtoJson.getBytes());
    // String signedPrivacyDataDTO = getSignedPrivacyDataDTO(base64, signatureRequest);
    // String base641 = Base64.getEncoder().encodeToString(signedPrivacyDataDTO.getBytes());
    // HashCode sha256hex = Hashing.sha256().hashString(signedPrivacyDataDTO, StandardCharsets.UTF_8);
    // String base58 = Base58.encode(sha256hex.asBytes());

    /**
     * Кодировка Base64.
     */
    @Test
    public void base64Test() {
        String testString = "Hello world";
        String base64String = Base64.getEncoder().encodeToString(testString.getBytes());
        log.info("Input string: {}", testString);
        log.info("Base64 string: {}", base64String);
        String decodeString = new String(Base64.getDecoder().decode(base64String.getBytes()), StandardCharsets.UTF_8);
        log.info("Decode string: {}", decodeString);


        String base58 = Base58.encode(testString.getBytes());

        HashCode hashCode = Hashing.sha256().hashString(testString, StandardCharsets.UTF_8);
        log.info("Hashcode: {}", hashCode);

    }

    @Test
    public void hashCodeTest() {

    }
}
