package pe.edu.tecsup.lab10;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class CustomIATest {

    @Test
    void getModel() {
        log.info("Starting test: getModel");

        String msg = CustomIA.getModel().chat("Generar solo la cuenta de un email de prueba");
        log.info("Response from AI: {}", msg);

        assertNotNull(msg);
        assertTrue(msg.contains("@"));
        log.info("Test passed successfully");


    }
}