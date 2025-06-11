package br.com.alura.ScreenMusic.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultGPT {
    public static String getInformation(String text) {
        OpenAiService service = new OpenAiService(System.getenv("OPENAI_APIKEY"));

        CompletionRequest request = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("tell me about the artist: " + text)
                .maxTokens(500)
                .temperature(0.7)
                .build();

        var response = service.createCompletion(request);
        System.out.println(response.getChoices().get(0).getText());
        return response.getChoices().get(0).getText();
    }
}