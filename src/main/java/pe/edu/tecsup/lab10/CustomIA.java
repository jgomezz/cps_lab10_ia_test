package pe.edu.tecsup.lab10;

import dev.langchain4j.model.openai.OpenAiChatModel;


public class CustomIA {

    public static OpenAiChatModel getModel () {
/*
        JdkHttpClientBuilder httpClientBuilder = new JdkHttpClientBuilder()
                .httpClientBuilder(HttpClient.newBuilder()
                        .version(HttpClient.Version.HTTP_1_1));
*/
        return OpenAiChatModel.builder()
                //.baseUrl("http://localhost:11434/v1")
                .baseUrl("http://localhost:3000/api/v1")
                .apiKey("Nose")
                .modelName("llama3.1:8b")
                .temperature(0.0)
                .logRequests(true)
                .logResponses(true)
                .build();

    }
}