package pe.edu.tecsup.lab10.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = AppConfig.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (input != null) {
                properties.load(input);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load application.properties", e);
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("openai.base-url");
    }

    public static String getApiKey() {
        return properties.getProperty("openai.api-key");
    }

    public static String getModelName() {
        return properties.getProperty("openai.model-name");
    }
}
