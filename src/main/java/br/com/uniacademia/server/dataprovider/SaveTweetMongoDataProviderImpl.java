package br.com.uniacademia.server.dataprovider;

import br.com.uniacademia.server.dataprovider.model.Tweet;
import br.com.uniacademia.server.dataprovider.repository.TweetMongoRepository;
import br.com.uniacademia.server.dataprovider.service.RemoveSpecialCharactersService;
import br.com.uniacademia.server.domain.dataprovider.SaveTweetMongoDataProvider;
import br.com.uniacademia.server.domain.dto.TweetDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class SaveTweetMongoDataProviderImpl implements SaveTweetMongoDataProvider {

    private final TweetMongoRepository mongoRepository;
    private final RemoveSpecialCharactersService removeSpecialCharactersService;
    private final StopWordsMemoryListDataProvider stopWordsMemoryListDataProvider;

    @Autowired
    public SaveTweetMongoDataProviderImpl(TweetMongoRepository mongoRepository, RemoveSpecialCharactersService removeSpecialCharactersService, StopWordsMemoryListDataProvider stopWordsMemoryListDataProvider) {
        this.mongoRepository = mongoRepository;
        this.removeSpecialCharactersService = removeSpecialCharactersService;
        this.stopWordsMemoryListDataProvider = stopWordsMemoryListDataProvider;
    }

    @Override
    public void save(TweetDto tweetDto) {
        var entities = Stream.of(removeSpecialCharactersService.execute(tweetDto).split(" "))
                .filter(this::isAlphabetic)
                .filter(this::isNotStopWord)
                .collect(Collectors.toList());

        var tweet = Tweet.create(tweetDto, entities);

        saveTweet(tweet);
    }

    private boolean isAlphabetic(String entity) {
        return entity.chars().anyMatch(Character::isAlphabetic);
    }

    private boolean isNotStopWord(String entity) {
        return !stopWordsMemoryListDataProvider.execute().contains(entity);
    }

    private void saveTweet(Tweet tweet) {
        try {
            log.info("(TweetService.saveTweet) -> Saving tweet.");
            mongoRepository.save(tweet);
        } catch (Exception e) {
            log.error("(TweetService.saveTweet) -> Could't save tweet at MongoDb. Msg: {}", e.getMessage());
        }
    }
}
