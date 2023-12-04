package br.com.joaogabriel.kafkaguide.controller;

import br.com.joaogabriel.kafkaguide.kafka.JsonKafkaProducer;
import br.com.joaogabriel.kafkaguide.payload.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka/json")
public class JsonMessageController {

    private final JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publish")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> publish(@RequestBody User user) {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Message was created.");
    }
}
