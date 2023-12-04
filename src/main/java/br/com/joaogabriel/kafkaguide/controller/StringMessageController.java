package br.com.joaogabriel.kafkaguide.controller;

import br.com.joaogabriel.kafkaguide.kafka.KafkaProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class StringMessageController {

    private final KafkaProducer kafkaProducer;

    public StringMessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        this.kafkaProducer.sendMessage(message);
        return ResponseEntity.status(HttpStatus.OK).body("Message sent to topic.");
    }

}
