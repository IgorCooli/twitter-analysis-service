package br.com.uniacademia.server.dataprovider;

import br.com.uniacademia.server.dataprovider.client.GoogleCloudClient;
import br.com.uniacademia.server.domain.dataprovider.SimpleTextSentimentAnalysisDataProvider;
import com.google.cloud.language.v1.AnalyzeSentimentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleTextSentimentAnalysisDataProviderImpl implements SimpleTextSentimentAnalysisDataProvider {

    private final GoogleCloudClient googleCloudClient;

    @Autowired
    public SimpleTextSentimentAnalysisDataProviderImpl(GoogleCloudClient googleCloudClient) {
        this.googleCloudClient = googleCloudClient;
    }

    @Override
    public AnalyzeSentimentResponse execute(String text) {
        return googleCloudClient.analyzeSimpleText(text);
    }
}
