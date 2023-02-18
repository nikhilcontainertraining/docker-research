package com.nikhil.containers.dockerresearch.api;

import com.nikhil.containers.dockerresearch.model.Card;
import com.nikhil.containers.dockerresearch.service.CardsHandler;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@Log4j2
public class CardsApi {

    static Logger log = LogManager.getLogger(CardsApi.class);

    @Autowired
    private CardsHandler cardsHandler;

    @CrossOrigin
    @GetMapping(value = "/cards")
    @ResponseBody
    public ResponseEntity<List<Card>> getCards() {
        log.trace("GET CARDS api STARTED");

        List<Card> cards = cardsHandler.getCards();

        log.trace("GET CARDS api COMPLETED");
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(cards);
    }

}
