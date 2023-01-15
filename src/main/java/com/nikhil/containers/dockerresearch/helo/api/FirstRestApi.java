package com.nikhil.containers.dockerresearch.helo.api;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.nikhil.containers.dockerresearch.DockerResearchApplication.serverName;

@RestController
@Log4j2
public class FirstRestApi {

    static Logger log = LogManager.getLogger(FirstRestApi.class);

    @RequestMapping("/joke")
    public String home() {
        log.trace("entered joke api");

        String message = RandomStringUtils.randomAlphanumeric(20);
        //System.out.println(serverName + " message log: " + message);

        log.info(serverName + " message log: " + message);

        log.trace("exiting joke api");
        return "Some Random Joke: " + message;
    }

}
