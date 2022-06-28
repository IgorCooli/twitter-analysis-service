package br.com.uniacademia.server.dataprovider.mapper;

import br.com.uniacademia.server.domain.dto.TweetDto;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TweetDtoMapper {

    public static TweetDto execute(String raw) {
        log.info("(TweetService.tweetDtoMapper) -> Serializing Tweet");
        var converter = new Gson();
        try {
            return converter.fromJson(raw, TweetDto.class);
        } catch (Exception e) {
            log.error("(TweetService.tweetDtoMapper) -> Error trying to serialize tweet. Msg: {}", e.getMessage());
            return new TweetDto();
        }
    }
}
