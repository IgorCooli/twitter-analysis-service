package br.com.uniacademia.server.dataprovider.repository;

import br.com.uniacademia.server.dataprovider.model.Tweet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetMongoRepository extends MongoRepository<Tweet, Long> {
}
