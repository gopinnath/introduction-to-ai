package ind.gopinnath.introduction_to_ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {
    
    @Bean
    public RestClient.Builder defaultRestClientBuilder() {
        return RestClient.builder();
    }

    @Bean
    ChatClient chatClient(ChatClient.Builder builder) {
        return builder.build();
    }
}
