package br.com.uniacademia.server.dataprovider.model;

import com.google.cloud.language.v1.AnalyzeSentimentResponse;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@ToString
public class TextSentiment {

    private BigDecimal magnitude;
    private BigDecimal score;
    private String language;

    public static TextSentiment create(AnalyzeSentimentResponse analyzeSentimentResponse) {
        var textSentiment = new TextSentiment();

        textSentiment.setMagnitude(BigDecimal.valueOf(analyzeSentimentResponse.getDocumentSentiment().getMagnitude()).setScale(1, RoundingMode.HALF_UP));
        textSentiment.setScore(BigDecimal.valueOf(analyzeSentimentResponse.getDocumentSentiment().getScore()).setScale(1, RoundingMode.HALF_UP));
        textSentiment.setLanguage(analyzeSentimentResponse.getLanguage());

        return textSentiment;
    }
}
