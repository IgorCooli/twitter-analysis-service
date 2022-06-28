package br.com.uniacademia.server.dataprovider.client;

import br.com.uniacademia.server.dataprovider.model.TextSentiment;
import br.com.uniacademia.server.domain.dto.TweetDto;
import com.google.cloud.language.v1.AnalyzeSentimentResponse;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.LanguageServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class GoogleCloudClient {

    private static final String LANGUAGE = "pt";

    public void analyze(TweetDto tweet) {
        this.analyzeTextAndSave(tweet);
//        this.analyzeEntitiesAndSave(tweet);
    }

    public AnalyzeSentimentResponse analyzeSimpleText(String text) {
        try (var language = LanguageServiceClient.create()) {
            var document = getDocument(text);

            var analyzeSentimentResponse = language.analyzeSentiment(document);

            log.info("(GoogleCloudClient.analyzeSimpleText) -> Saving sentiment analysis.");
            return analyzeSentimentResponse;
        } catch (IOException e) {
            log.error("(GoogleCloudClient.analyzeSimpleText) -> Coudn't connect to Google Cloud services. Msg: {}", e.getMessage());
            return null;
        }
    }

    private void analyzeTextAndSave(TweetDto tweet) {
        try (var language = LanguageServiceClient.create()) {
            var document = getTwitterDocument(tweet);

            var analyzeSentimentResponse = language.analyzeSentiment(document);

            log.info("(GoogleCloudClient.analyzeText) -> Saving sentiment analysis.");
            tweet.setTextSentiment(TextSentiment.create(analyzeSentimentResponse));
        } catch (IOException e) {
            log.error("(GoogleCloudClient.analyzeText) -> Coudn't connect to Google Cloud services. Msg: {}", e.getMessage());
        }
    }

//    private void analyzeEntitiesAndSave(TweetDto tweet) {
//        try (var language = LanguageServiceClient.create()) {
//            var document = getDocument(tweet);
//            var analyzeEntitiesResponse = language.analyzeEntities(document);
//
//            var entities = analyzeEntitiesResponse.getEntitiesList()
//                    .stream()
//                    .map(TextEntity::create)
//                    .collect(Collectors.toList());
//
//            log.info("(GoogleCloudClient.analyzeEntities) -> Saving entities.");
//            tweet.setEntities(entities);
//        } catch (IOException e) {
//            log.error("(GoogleCloudClient.analyzeEntities) -> Coudn't connect to Google Cloud services. Msg: {}", e.getMessage());
//        }
//    }

    private Document getTwitterDocument(TweetDto tweet) {
        return getDocument(tweet.getText());
    }

    private Document getDocument(String text) {
        return Document.newBuilder()
                .setContent(text)
                .setType(Document.Type.PLAIN_TEXT)
                .setLanguage(LANGUAGE)
                .build();
    }

}
