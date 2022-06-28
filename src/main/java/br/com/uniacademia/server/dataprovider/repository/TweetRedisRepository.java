package br.com.uniacademia.server.dataprovider.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;

@Repository
public class TweetRedisRepository {
    private final Integer DURATION_FIVE_MINUTES = 1000 * 60 * 5;

    private final StringRedisTemplate redisTemplate;

    @Autowired
    public TweetRedisRepository(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public String blPop() {
        return redisTemplate.opsForList().leftPop("tweet-channel", Duration.ofSeconds(DURATION_FIVE_MINUTES));
    }

}
