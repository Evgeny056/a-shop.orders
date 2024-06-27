package com.ashoporders.messaging.producer.impl;

import com.ashoporders.messaging.producer.MessageProducer;
import com.ashoporders.model.dto.CreateOrderRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class NewOrdersProducer implements MessageProducer<CreateOrderRequestDto> {

    private final KafkaTemplate<String,CreateOrderRequestDto> kafkaTemplate;

    @Value("${kafka.topics.new_orders}")
    private String newOrdersTopic;

    @Override
    public void sendMessage(CreateOrderRequestDto dto) {
        CompletableFuture<SendResult<String, CreateOrderRequestDto>> future = kafkaTemplate.send(
                newOrdersTopic, dto
        );
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message to topic {} with offset {}", newOrdersTopic, result.getRecordMetadata().offset());
            } else {
                log.error("Unable to send message to topic {} due to : {}", newOrdersTopic, ex.getMessage());
            }
        });
    }
}
