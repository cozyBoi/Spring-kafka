package com.example.service;

import com.example.dto.FlowDto;
import com.example.entity.Flow;
import com.example.repository.FlowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlowService {
    private final FlowRepository flowRepository;

    public void addDB(FlowDto flowDto){
        flowRepository.save(new Flow(null, flowDto.getFlowInfo(), flowDto.isBuild()));
    }
}
