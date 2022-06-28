package br.com.uniacademia.server.dataprovider.service;

import br.com.uniacademia.server.domain.dto.TweetDto;
import org.springframework.stereotype.Service;

@Service
public class RemoveSpecialCharactersService {
    public String execute(TweetDto tweetDto) {
        return tweetDto.getText()
                .replace( "." , "")
                .replace( "/" , "")
                .replace( "-" , "")
                .replace( ";" , "")
                .replace( "!" , "")
                .replace( "?" , "")
                .replace( "," , "")
                .replace( "(" , "")
                .replace( ")" , "")
                .replace( "{" , "")
                .replace( "}" , "")
                .replace( "[" , "")
                .replace( "]" , "")
                .replace( "  " , " ");
    }
}
