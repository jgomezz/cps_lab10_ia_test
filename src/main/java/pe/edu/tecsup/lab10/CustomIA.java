package pe.edu.tecsup.lab10;

import dev.langchain4j.model.openai.OpenAiChatModel;

public class CustomIA {

    public static OpenAiChatModel getModel () {

        return OpenAiChatModel.builder()
                .baseUrl("http://192.168.17.11:3000")
                .apiKey("Nose")
                .modelName("mistralai/Ministral-3-14B-Instruct-2512")
                .temperature(0.0)
                .build();
    }
}