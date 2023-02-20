package com.example.controller;

import com.example.service.ConsumerService;
import com.example.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class MainController {

    private final ProducerService producerService;

    @GetMapping("/exec")
    public void exec(){
        producerService.send();
    }
}
