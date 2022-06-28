package br.com.uniacademia.server.domain.dataprovider;

import br.com.uniacademia.server.domain.dto.TweetDto;

import java.util.List;

public interface RetrieveTweetsDataProvider {
    List<TweetDto> findTweets();
}
