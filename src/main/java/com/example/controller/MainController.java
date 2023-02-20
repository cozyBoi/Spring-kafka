package com.example.controller;

import com.example.dto.FlowDto;
import com.example.service.ConsumerService;
import com.example.service.FlowService;
import com.example.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class MainController {

    private final ProducerService producerService;
    private final FlowService flowService;

    @PostMapping("/submit")
    public void submit(@RequestBody FlowDto flowDto){
        System.out.println(flowDto.getFlowInfo());
        System.out.println(flowDto.isBuild());
        flowService.addDB(flowDto);
        producerService.send(flowDto);
    }
}
