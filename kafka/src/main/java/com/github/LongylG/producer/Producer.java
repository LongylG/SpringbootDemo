package com.github.LongylG.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    //发送消息方法
    public void send(String message) {
        message = "{\"clientId\":\"1\",\"salt\":{\"salt\":\"1312\",\"encrypted\":true}}";
        kafkaTemplate.send("client-salt", message);
    }
}
