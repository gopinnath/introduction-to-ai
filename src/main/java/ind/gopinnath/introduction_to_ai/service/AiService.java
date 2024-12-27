package ind.gopinnath.introduction_to_ai.service;

import reactor.core.publisher.Flux;

public interface AiService {
    
    public String getBasicResponse(String systemPrompt, String userPrompt);

    public Flux<String> streamBasicResponse(String systemPrompt, String userPrompt);

}