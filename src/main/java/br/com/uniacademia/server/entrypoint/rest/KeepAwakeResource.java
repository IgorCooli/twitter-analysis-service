package br.com.uniacademia.server.entrypoint.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/keep-alive")
public class KeepAwakeResource {

    @GetMapping("/execute")
    public void execute() {
        log.info("(KeepAwakeResource.execute) -> Receiving keep alive request");
    }

}
