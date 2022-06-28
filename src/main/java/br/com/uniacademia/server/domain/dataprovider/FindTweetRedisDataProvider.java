package br.com.uniacademia.server.domain.dataprovider;

import br.com.uniacademia.server.domain.dto.TweetDto;

public interface FindTweetRedisDataProvider {
    TweetDto find();
}
