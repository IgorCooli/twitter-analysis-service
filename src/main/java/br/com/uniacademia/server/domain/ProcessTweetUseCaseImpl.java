package br.com.uniacademia.server.domain;

import br.com.uniacademia.server.domain.dataprovider.FindTweetRedisDataProvider;
import br.com.uniacademia.server.domain.dataprovider.SaveTweetMongoDataProvider;
import br.com.uniacademia.server.domain.dataprovider.TweetSentimentAnalysisDataProvider;
import br.com.uniacademia.server.domain.dto.TweetDto;
import br.com.uniacademia.server.entrypoint.domain.ProcessTweetUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProcessTweetUseCaseImpl implements ProcessTweetUseCase {

    private final FindTweetRedisDataProvider findTweetRedisDataProvider;
    private final TweetSentimentAnalysisDataProvider tweetSentimentAnalysisDataProvider;
    private final SaveTweetMongoDataProvider saveTweetMongoDataProvider;

    @Autowired
    public ProcessTweetUseCaseImpl(FindTweetRedisDataProvider findTweetRedisDataProvider,
                                   TweetSentimentAnalysisDataProvider tweetSentimentAnalysisDataProvider,
                                   SaveTweetMongoDataProvider saveTweetMongoDataProvider) {
        this.findTweetRedisDataProvider = findTweetRedisDataProvider;
        this.tweetSentimentAnalysisDataProvider = tweetSentimentAnalysisDataProvider;
        this.saveTweetMongoDataProvider = saveTweetMongoDataProvider;
    }

    public void execute() {
        var tweet = findTweet();
        log.info("(TweetService.getTweetAndAnalyzeAndSave) -> Starting analysis.");

        analyseSentiment(tweet);

        saveTweet(tweet);
    }

    private TweetDto findTweet() {
        return findTweetRedisDataProvider.find();
    }

    private void analyseSentiment(TweetDto tweet) {
        tweetSentimentAnalysisDataProvider.execute(tweet);
    }

    private void saveTweet(TweetDto tweet) {
        saveTweetMongoDataProvider.save(tweet);
    }
}
