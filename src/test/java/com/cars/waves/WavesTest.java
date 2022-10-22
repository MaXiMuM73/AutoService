package com.cars.waves;

import com.wavesenterprise.utils.Base58;
import com.wavesenterprise.utils.Base64;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

@Slf4j
public class WavesTest {

    /**
     * Тестирование алгоритма кодирования Base 58 Waves VS Custom
     */
    @Test
    public void testBase58() {
        String input = "Test";
        log.info("Input: {}", input);
        // Waves Base58
        String wavesBase58 = Base58.encode(input.getBytes());
        log.info("Waves base 58 encoded: {}", wavesBase58);
        String decoded = new String(Base58.decode(wavesBase58).get());
        log.info("Waves base 58 decoded: {}", decoded);

        // Custom Base58
        String customBase58 = com.cars.encrypt.Base58.encode(input.getBytes());
        log.info("Custom base 58 encoded: {}", wavesBase58);
        String decodedCustom = new String(Base58.decode(wavesBase58).get());
        log.info("Custom base 58 decoded: {}", decodedCustom);
    }

    /**
     * Тестирование алгоритма кодирования Base 64 Waves VS Java
     */
    @Test
    public void testBase64() {
        String input = "Test";
        log.info("Input: {}", input);

        // Waves Base64
        String wavesBase64 = Base64.encode(input.getBytes());
        log.info("Waves base 64 encoded: {}", wavesBase64);
        String decoded = new String(Base64.decode(wavesBase64).get());
        log.info("Waves base 64 decoded: {}", decoded);

        // Java Base64
        String javaBase64 = java.util.Base64.getEncoder().encodeToString(input.getBytes());
        log.info("Java base 64 encoded: {}", javaBase64);
        String decodedJava = new String(Base64.decode(wavesBase64).get());
        log.info("Java base 64 decoded: {}", decodedJava);
    }

    @Test
    public void transactionTest() {
        LocalDateTime now = LocalDateTime.now();
        log.info("test");

    }
}
