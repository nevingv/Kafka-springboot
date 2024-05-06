package com.projectx.kafka.consumer;

import com.projectx.kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    /*
    @KafkaListener(topics = "myTopic",groupId = "myGroup")
    public void consumeMessage(String message){
        log.info(String.format("Consumed message from topic :: myTopic :: %s",message));
    }*/

    @KafkaListener(topics = "myTopic",groupId = "myGroup")
    public void consumeMessage(Student student){
        log.info(String.format("Consumed message from topic :: myTopic ::%s",student.toString()));
    }
}
