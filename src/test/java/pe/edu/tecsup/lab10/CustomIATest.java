package pe.edu.tecsup.lab10;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
class CustomIATest {

    @Test
    void verificarConfigLogger() {
        var url = getClass().getClassLoader().getResource("simplelogger.properties");
        System.out.println("Config encontrada en: " + url);
    }

    @Test
    void getModel() {

        String msg = CustomIA.getModel().chat("Generar un cuenta de  email de prueba");

        //log.info("MSG -->" + msg);

        assertNotNull(msg);
        assertTrue(msg.contains("@"));


    }
}