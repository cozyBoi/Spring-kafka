package com.example.service;

import com.example.Utils.EventMsg;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Service
@RequiredArgsConstructor
public class ConsumerService {
    @KafkaListener( //thread 하나 파서 계속 poll
            topics = "test",
            groupId = "1",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listenGroupOne(EventMsg message) {
        message.setConsumeTime(new Timestamp(System.currentTimeMillis()));
        System.out.println("Received Message in group 1: ");
        System.out.println("[EventType] " + message.getEventType());
        System.out.println("[EventData] " + message.getEventData().getEventDB());
        System.out.println("[IssueTime] " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(message.getIssueTime()));
        System.out.println("[ConsumeTime] " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(message.getConsumeTime()));
    }
}
