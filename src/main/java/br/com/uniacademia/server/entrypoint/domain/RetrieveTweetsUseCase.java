package br.com.uniacademia.server.entrypoint.domain;

import br.com.uniacademia.server.domain.dto.TweetDto;

import java.util.List;

public interface RetrieveTweetsUseCase {
    List<TweetDto> findTweets();
}
