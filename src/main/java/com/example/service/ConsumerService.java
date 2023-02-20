package com.example.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumerService {
    @KafkaListener(topics = "test", groupId = "1")
    public void listenGroupOne(String message) {
        System.out.println("Received Message in group 1: " + message);
    }
}
