package com.example.service;

import com.example.Utils.EventData;
import com.example.Utils.EventMsg;
import jakarta.websocket.SendResult;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class ProducerService {
    private final KafkaTemplate<String, EventMsg> kafkaTemplate;

    public void send(){
        EventMsg eventMsg = EventMsg.builder()
                .eventType("testEvent")
                .eventData(new EventData("testDB"))
                .issueTime(new Timestamp(System.currentTimeMillis()))
                .build();
        kafkaTemplate.send("test", eventMsg);
    }
}
