package br.com.uniacademia.server.dataprovider;

import br.com.uniacademia.server.dataprovider.client.GoogleCloudClient;
import br.com.uniacademia.server.domain.dataprovider.TweetSentimentAnalysisDataProvider;
import br.com.uniacademia.server.domain.dto.TweetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetSentimentAnalysisDataProviderImpl implements TweetSentimentAnalysisDataProvider {

    private final GoogleCloudClient googleCloudClient;

    @Autowired
    public TweetSentimentAnalysisDataProviderImpl(GoogleCloudClient googleCloudClient) {
        this.googleCloudClient = googleCloudClient;
    }

    @Override
    public void execute(TweetDto tweetDto) {
        googleCloudClient.analyze(tweetDto);
    }
}
