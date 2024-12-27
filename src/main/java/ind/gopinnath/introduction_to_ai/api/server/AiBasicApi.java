package ind.gopinnath.introduction_to_ai.api.server;

import ind.gopinnath.introduction_to_ai.api.request.AiPromptRequest;
import ind.gopinnath.introduction_to_ai.service.AiService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/ai")
@Validated
public class AiBasicApi {

    private final AiService service;

    public AiBasicApi(AiService service) {
        this.service = service;
    }

    @PostMapping(path = "/v1/basic", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public Mono<String> basicAi(@RequestBody @Valid AiPromptRequest request) {
        return Mono.just(service.getBasicResponse(request.systemPrompt(), request.userPrompt()));
    }

    @PostMapping(path = "/v1/basic/stream", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<String> basicStreamAi(@RequestBody @Valid AiPromptRequest request) {
        return service.streamBasicResponse(request.systemPrompt(), request.userPrompt());
    }

}
