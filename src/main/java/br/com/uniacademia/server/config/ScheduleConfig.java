package br.com.uniacademia.server.config;

import br.com.uniacademia.server.entrypoint.job.TweetJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class ScheduleConfig {
    @Bean
    public TweetJob tweetBotJob() {
        return new TweetJob();
    }
}
