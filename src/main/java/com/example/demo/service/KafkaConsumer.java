package com.example.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class KafkaConsumer {

    private final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = "${app.topic}", groupId = "${spring.kafka.groupId}")
    public void listen(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }
}
