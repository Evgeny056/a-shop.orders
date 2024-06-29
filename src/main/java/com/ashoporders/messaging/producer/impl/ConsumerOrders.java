package com.ashoporders.messaging.producer.impl;

import com.ashoporders.messaging.producer.MessageProducer;
import com.ashoporders.model.dto.CreateOrderRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ConsumerOrders implements MessageProducer<CreateOrderRequestDto> {

    private String newTopicOrders = "new_orders";

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void sendMessage(CreateOrderRequestDto createOrderRequestDto) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(createOrderRequestDto);
            log.info("Sending message to {}: {}", newTopicOrders, jsonMessage);
            kafkaTemplate.send(newTopicOrders, jsonMessage);
        } catch (JsonProcessingException e) {
            log.error("Error while converting object to JSON: {}", e.getMessage());
        }
    }

}
