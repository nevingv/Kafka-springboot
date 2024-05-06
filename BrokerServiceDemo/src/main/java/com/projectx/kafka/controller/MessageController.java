package com.projectx.kafka.controller;

import com.projectx.kafka.payload.Student;
import com.projectx.kafka.producer.KafkaJsonProducer;
import com.projectx.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {
    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(
            @RequestBody String message ){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to queue successfully");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendMessage(
            @RequestBody Student student ){
        kafkaJsonProducer.sendMessage(student);
        return ResponseEntity.ok("Message sent to queue successfully as JSON");
    }

}
