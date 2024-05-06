package com.projectx.wikimedia.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WikimediaConsumer {
    @KafkaListener(topics = "wikimediaStream",groupId = "myGroup")
    public void consumeMessage(String msg){
        log.info(String.format("Consumed message from topic :: wikimediaStream :: %s",msg));

    }

}