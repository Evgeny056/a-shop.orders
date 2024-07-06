package com.ashoporders.messaging.producer.impl;

import com.ashoporders.messaging.producer.MessageProducer;
import com.ashoporders.model.dto.CreateOrderRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProducerOrders implements MessageProducer<CreateOrderRequestDto> {

    private String newTopicOrders = "new_orders";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(CreateOrderRequestDto createOrderRequestDto) {
        String key = String.valueOf(createOrderRequestDto.hashCode());
        log.info("Sending message to {}: {} with key {", newTopicOrders, createOrderRequestDto, key);
            kafkaTemplate.send(newTopicOrders, key, createOrderRequestDto);
    }
}
