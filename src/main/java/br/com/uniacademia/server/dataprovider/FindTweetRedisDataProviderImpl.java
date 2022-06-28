package br.com.uniacademia.server.dataprovider;

import br.com.uniacademia.server.dataprovider.mapper.TweetDtoMapper;
import br.com.uniacademia.server.dataprovider.repository.TweetRedisRepository;
import br.com.uniacademia.server.domain.dataprovider.FindTweetRedisDataProvider;
import br.com.uniacademia.server.domain.dto.TweetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindTweetRedisDataProviderImpl implements FindTweetRedisDataProvider {

    private final TweetRedisRepository redisRepository;

    @Autowired
    public FindTweetRedisDataProviderImpl(TweetRedisRepository redisRepository) {
        this.redisRepository = redisRepository;
    }

    @Override
    public TweetDto find() {
        var rawTweet = redisRepository.blPop();

        return TweetDtoMapper.execute(rawTweet);
    }
}
