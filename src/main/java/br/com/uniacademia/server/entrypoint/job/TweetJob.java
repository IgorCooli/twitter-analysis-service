package br.com.uniacademia.server.entrypoint.job;

import br.com.uniacademia.server.entrypoint.domain.ProcessTweetUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
public class TweetJob {

    @Autowired
    private ProcessTweetUseCase processTweetUseCase;

    @Scheduled(fixedDelay = 1000L)
    public void searchRedisForTweets() {
        try {
            log.info("(TweetBotJob.searchRedisForTweets) -> Searching for tweet at Redis.");

            processTweetUseCase.execute();
        } catch (Exception e) {
            log.error("(TweetBotJob.searchRedisForTweets) -> Error trying to access Redis database. Msg: {}", e.getMessage());
        }
    }
}
