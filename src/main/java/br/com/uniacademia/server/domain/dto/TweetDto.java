package br.com.uniacademia.server.domain.dto;

import br.com.uniacademia.server.dataprovider.model.Hashtag;
import br.com.uniacademia.server.dataprovider.model.TextSentiment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TweetDto {

    private String createdAt;
    private Long tweetId;
    private String text;
    private String source;
    private Long userId;
    private String userName;
    private String userLocation;
    private Object coordinates;
    private String userUrl;
    private Integer userFollowersCounts;
    private Integer userFavouritesCount;
    private Integer userStatusesCount;
    private String userCreatedAt;
    private Integer replyCount;
    private Integer retweetCount;
    private Integer favoriteCount;
    private List<Hashtag> hashtags;
    private TextSentiment textSentiment;
//    private List<TextEntity> entities;
    private List<String> entities;

}
