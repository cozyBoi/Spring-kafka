package com.example.service;

import com.example.Utils.EventData;
import com.example.Utils.EventMsg;
import com.example.dto.FlowDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class ProducerService {
    private final KafkaTemplate<String, EventMsg> kafkaTemplate;

    public void send(FlowDto flowDto){
        EventMsg eventMsg = EventMsg.builder()
                .eventType("testEvent")
                .eventData(new EventData("testDB", flowDto.getFlowInfo(), flowDto.isBuild()))
                .issueTime(new Timestamp(System.currentTimeMillis()))
                .build();
        kafkaTemplate.send("test", eventMsg);
    }
}
