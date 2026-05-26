package pe.edu.tecsup.lab10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomIATest {

    @Test
    void getModel() {

        String msg = CustomIA.getModel()
                .chat("Generar un email de prueba");

        assertNotNull(msg);
        assertTrue(msg.contains("@"));


    }
}