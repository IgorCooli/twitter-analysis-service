package br.com.uniacademia.server.dataprovider.model;

import br.com.uniacademia.server.domain.dto.TweetDto;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@ToString
@Document(collection = "tweet")
public class Tweet {

    @Id
    private Long tweetId;
    private String createdAt;
    private String text;
    private String source;
    private Integer replyCount;
    private Integer retweetCount;
    private Integer favoriteCount;
    private User user;
    private List<Hashtag> hashtags;
    private TextSentiment textSentiment;
    //    private List<TextEntity> entities;
    private List<String> entities;

    public static Tweet create(TweetDto tweetDto, List<String> entities) {
        var tweet = new Tweet();
        var user = new User();

        user.setUserId(tweetDto.getUserId());
        user.setUserCreatedAt(tweetDto.getUserCreatedAt());
        user.setCoordinates(tweetDto.getCoordinates());
        user.setUserUrl(tweetDto.getUserUrl());
        user.setUserLocation(tweetDto.getUserLocation());
        user.setUserName(tweetDto.getUserName());
        user.setUserFavouritesCount(tweetDto.getUserFavouritesCount());
        user.setUserFollowersCounts(tweetDto.getUserFollowersCounts());
        user.setUserStatusesCount(tweetDto.getUserStatusesCount());

        tweet.setCreatedAt(tweetDto.getCreatedAt());
        tweet.setTweetId(tweetDto.getTweetId());
        tweet.setText(tweetDto.getText());
        tweet.setSource(tweetDto.getSource());
        tweet.setReplyCount(tweetDto.getReplyCount());
        tweet.setRetweetCount(tweetDto.getRetweetCount());
        tweet.setFavoriteCount(tweetDto.getFavoriteCount());
        tweet.setUser(user);
        tweet.setHashtags(tweetDto.getHashtags());
        tweet.setTextSentiment(tweetDto.getTextSentiment());
        tweet.setEntities(entities);

        return tweet;
    }

    public TweetDto toDomain() {
        return new TweetDto(createdAt, tweetId, text, source, user.getUserId(), user.getUserName(),
                user.getUserLocation(), user.getCoordinates(), user.getUserUrl(), user.getUserFollowersCounts(),
                user.getUserFavouritesCount(), user.getUserStatusesCount(), user.getUserCreatedAt(),
                replyCount, retweetCount, favoriteCount, hashtags, textSentiment, entities);
    }
}
