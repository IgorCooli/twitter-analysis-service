package br.com.uniacademia.server.entrypoint.rest;

import br.com.uniacademia.server.domain.dto.TweetDto;
import br.com.uniacademia.server.entrypoint.domain.RetrieveTweetsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tweet")
public class RetrieveTweetsResouce {

    private final RetrieveTweetsUseCase useCase;

    @Autowired
    public RetrieveTweetsResouce(RetrieveTweetsUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/execute")
    public ResponseEntity<List<TweetDto>> execute(){
        return ResponseEntity.ok(useCase.findTweets());
    }

}
