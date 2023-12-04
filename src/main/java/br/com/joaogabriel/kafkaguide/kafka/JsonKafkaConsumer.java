package br.com.joaogabriel.kafkaguide.kafka;

import br.com.joaogabriel.kafkaguide.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "guides", groupId = "myGroup")
    public void consume(User user) {
        logger.info(String.format("Json message received: %s", user.toString()));
    }
}
