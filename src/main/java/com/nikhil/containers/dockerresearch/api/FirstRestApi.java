package com.nikhil.containers.dockerresearch.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nikhil.containers.dockerresearch.model.User;
import com.nikhil.containers.dockerresearch.model.Users;
import com.nikhil.containers.dockerresearch.service.FileHandler;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import static com.nikhil.containers.dockerresearch.DockerResearchApplication.userName;

@CrossOrigin
@RestController
@Log4j2
public class FirstRestApi {

    static Logger log = LogManager.getLogger(FirstRestApi.class);

    @Autowired
    FileHandler fileHandler;

//    @GetMapping(
//            value = "/getfile/{filename}",
//            produces = MediaType.APPLICATION_JSON_VALUE)


    @CrossOrigin
    @GetMapping(value = "/getfile/{filename}")
    @ResponseBody
    public ResponseEntity<InputStreamResource> gtFile(@PathVariable String filename) throws IOException {
        log.trace("entered GET joke api");

        //byte[] bytes = fileHandler.getFile(filename+".json");
        InputStream in = fileHandler.getFile(filename+".json");

        log.trace("exited GET joke api");
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new InputStreamResource(in));
    }


    @CrossOrigin
    @RequestMapping("/joke")
    public String home() throws JsonProcessingException {
        log.trace("entered joke api");

        String message = RandomStringUtils.randomAlphanumeric(20);

        User user = new User();
        user.setName(userName);
        user.setId(UUID.randomUUID().toString());
        user.setMessage(message);
        user.setFileLink("http://localhost:8080/getfile/" + message);

        Users users = new Users();
        users.addUser(user);


        fileHandler.createJsonFile(user);

        log.info(userName + " message log: " + message);

        log.trace("exiting joke api");

        return new ObjectMapper().writeValueAsString(users);

//        return buildResponseHtml(
//                "http://localhost:8080/getfile/" + message
////                , "http://localhost:8080/joke_vol/" + message + ".json"
////                , "http://localhost:8080/app/joke_vol/" + message + ".json"
////                , "http://localhost:8080/" + message + ".json"
////                , "http://localhost:8080/templates/" + message + ".json"
////                , "http://localhost:8080/webapp/" + message + ".json"
//        );
    }

    private String buildResponseHtml(String... content) {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Page Title</title>\n" +
                "</head>\n" +
                "<body>" +
                "<p>\n" +
                "<a href='" + content[0] + "'>" + content[0] + "</a>\n" +
                "</p>\n" +

//                "<p>\n" +
//                "<a href='" + content[1] + "'>" + content[1] + "</a>\n" +
//                "</p>\n" +
//
//                "<p>\n" +
//                "<a href='" + content[2] + "'>" + content[2] + "</a>\n" +
//                "</p>\n" +

//                "<p>\n" +
//                "<a href='" + content[3] + "'>" + content[3] + "</a>\n" +
//                "</p>\n" +

                "</body>\n" +
                "</html>\n" +
                "\n";
    }

}
