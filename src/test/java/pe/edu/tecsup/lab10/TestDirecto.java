package pe.edu.tecsup.lab10;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TestDirecto {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        String body = """
                {"model":"llama3.1:8b","messages":[{"role":"user","content":"hola"}],"temperature":0.0,"stream":false}
                """;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:3000/ollama/v1/chat/completions"))
                .header("Authorization", "Bearer sk-730a59f8c83f45848739a4465f8e12fc")
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.body());
    }
}