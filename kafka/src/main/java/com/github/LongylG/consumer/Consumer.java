package com.github.LongylG.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Consumer {

    @KafkaListener(topics = {"client-salt"})
    public void listen(ConsumerRecord<?, ?> record) throws JsonProcessingException {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println("---->" + record);
            System.out.println("---->" + new ObjectMapper().writeValueAsString(message));
        }

    }
}
