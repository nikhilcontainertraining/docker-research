package com.nikhil.containers.dockerresearch.api;

import com.nikhil.containers.dockerresearch.model.Card;
import com.nikhil.containers.dockerresearch.service.MovieHandler;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@Log4j2
public class MoviesApi {

    static Logger log = LogManager.getLogger(MoviesApi.class);

    @Autowired
    private MovieHandler movieHandler;

    @GetMapping(value = "/movies")
    @ResponseBody
    public ResponseEntity<List<Card>> getMovies() throws IOException {
        log.trace("entered GET MOVIES api");

        List<Card> cards = movieHandler.getMovies();

        log.trace("exited GET joke api");
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(cards);
    }

}
