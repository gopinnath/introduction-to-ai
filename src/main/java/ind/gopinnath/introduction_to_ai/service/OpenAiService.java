package ind.gopinnath.introduction_to_ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Service
public class OpenAiService implements AiService {

    private final ChatClient chatClient;

    public OpenAiService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public String getBasicResponse(String systemPrompt, String userPrompt) {
        Assert.hasText(userPrompt, "User prompt must not be empty");
        return this.chatClient.prompt()
                .system(Optional.ofNullable(systemPrompt).orElse(""))
                .user(userPrompt)
                .call().content();
    }

    @Override
    public Flux<String> streamBasicResponse(String systemPrompt, String userPrompt) {
        Assert.hasText(userPrompt, "User prompt must not be empty");
        return this.chatClient.prompt()
                .system(Optional.ofNullable(systemPrompt).orElse(""))
                .user(userPrompt)
                .stream().content();
    }
}
