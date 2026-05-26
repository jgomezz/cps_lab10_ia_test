package pe.edu.tecsup.lab10;

import pe.edu.tecsup.lab10.config.AppConfig;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SimpleIA {

    // Read config values first
    private static final String BASE_URL = AppConfig.getBaseUrl();
    private static final String API_KEY = AppConfig.getApiKey();
    private static final String MODEL_NAME = AppConfig.getModelName();

    private static final HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .build();

    public static String chat(String message) {
        try {
            String body = """
                    {
                      "model": "%s",
                      "messages": [{"role": "user", "content": "%s"}],
                      "temperature": 0.0,
                      "stream": false
                    }
                    """.formatted(MODEL_NAME, message);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/chat/completions"))
                    .header("Authorization", "Bearer " + API_KEY)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("API error: " + response.statusCode() + " - " + response.body());
            }

            return response.body();

        } catch (Exception e) {
            throw new RuntimeException("Failed to call AI API", e);
        }
    }
}
