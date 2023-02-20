package com.example.Utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EventMsg {
    private String eventType;
    private EventData eventData;
    private Timestamp issueTime;
    private Timestamp consumeTime;

    public void setConsumeTime(Timestamp timestamp){
        consumeTime = timestamp;
    }
}
