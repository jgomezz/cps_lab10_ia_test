package pe.edu.tecsup.lab10;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SimpleIATest {

    @Test
    void chat() {
        log.info("Starting test: chat");

        String response = SimpleIA.chat("Generar solo la cuenta de un email de prueba");
        log.info("Response from AI: {}", response);

        assertNotNull(response);
        assertTrue(response.contains("@"));
        log.info("Test passed successfully");
    }
}
