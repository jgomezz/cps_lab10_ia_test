package pe.edu.tecsup.lab10;

import dev.langchain4j.http.client.jdk.JdkHttpClientBuilder;
import dev.langchain4j.model.openai.OpenAiChatModel;
import pe.edu.tecsup.lab10.config.AppConfig;

import java.net.http.HttpClient;

public class CustomIA {

    // Read config values first
    private static final String BASE_URL = AppConfig.getBaseUrl();
    private static final String API_KEY = AppConfig.getApiKey();
    private static final String MODEL_NAME = AppConfig.getModelName();

    public static OpenAiChatModel getModel() {

        return OpenAiChatModel.builder()
                .baseUrl(BASE_URL)
                .apiKey(API_KEY)
                .modelName(MODEL_NAME)
                .temperature(0.0)
                .httpClientBuilder(new JdkHttpClientBuilder()
                        .httpClientBuilder(HttpClient.newBuilder()
                                .version(HttpClient.Version.HTTP_1_1)))
                .build();
    }
}
