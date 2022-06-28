package br.com.uniacademia.server.dataprovider;

import br.com.uniacademia.server.dataprovider.model.Tweet;
import br.com.uniacademia.server.dataprovider.repository.TweetMongoRepository;
import br.com.uniacademia.server.domain.dataprovider.RetrieveTweetsDataProvider;
import br.com.uniacademia.server.domain.dto.TweetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetrieveTweetsDataProviderImpl implements RetrieveTweetsDataProvider {

    private final TweetMongoRepository repository;

    @Autowired
    public RetrieveTweetsDataProviderImpl(TweetMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TweetDto> findTweets() {
        var result = repository.findAll();

        return result.stream()
                .map(Tweet::toDomain)
                .collect(Collectors.toList());
    }
}
