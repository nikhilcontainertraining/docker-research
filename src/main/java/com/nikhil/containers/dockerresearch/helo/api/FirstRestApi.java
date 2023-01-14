package com.nikhil.containers.dockerresearch.helo.api;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestApi {

    @RequestMapping("/joke")
    public String home() {
        String message = RandomStringUtils.randomAlphanumeric(20);
        System.out.println("the message log: " + message);
        return "Some Random Joke: " + message;
    }

}
