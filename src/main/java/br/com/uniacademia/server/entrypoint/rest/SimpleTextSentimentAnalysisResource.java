package br.com.uniacademia.server.entrypoint.rest;

import br.com.uniacademia.server.entrypoint.domain.SimpleTextSentimentAnalysisUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/text")
public class SimpleTextSentimentAnalysisResource {

    private final SimpleTextSentimentAnalysisUseCase useCase;

    @Autowired
    public SimpleTextSentimentAnalysisResource(SimpleTextSentimentAnalysisUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping
    public String execute(@RequestParam String text) {
        return "Score: " + useCase.execute(text).getDocumentSentiment().getScore() +
                ", Magnitude: " + useCase.execute(text).getDocumentSentiment().getMagnitude() +
                ", Language: " + useCase.execute(text).getLanguage();
    }
}
