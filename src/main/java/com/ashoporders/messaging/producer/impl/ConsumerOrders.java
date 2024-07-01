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
public class ConsumerOrders implements MessageProducer<CreateOrderRequestDto> {

    private String newTopicOrders = "new_orders";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(CreateOrderRequestDto createOrderRequestDto) {
            log.info("Sending message to {}: {}", newTopicOrders, createOrderRequestDto);
            kafkaTemplate.send(newTopicOrders, createOrderRequestDto);
    }
}
