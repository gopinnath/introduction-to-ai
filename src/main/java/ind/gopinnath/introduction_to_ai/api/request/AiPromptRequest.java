package ind.gopinnath.introduction_to_ai.api.request;

import jakarta.validation.constraints.NotBlank;

public record AiPromptRequest(String systemPrompt, @NotBlank String userPrompt) {

}
