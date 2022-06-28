package br.com.uniacademia.server.domain;

import br.com.uniacademia.server.domain.dataprovider.RetrieveTweetsDataProvider;
import br.com.uniacademia.server.domain.dto.TweetDto;
import br.com.uniacademia.server.entrypoint.domain.RetrieveTweetsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetrieveTweetsUseCaseImpl implements RetrieveTweetsUseCase {

    private final RetrieveTweetsDataProvider dataProvider;

    @Autowired
    public RetrieveTweetsUseCaseImpl(RetrieveTweetsDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    @Override
    public List<TweetDto> findTweets() {
        return dataProvider.findTweets();
    }
}
