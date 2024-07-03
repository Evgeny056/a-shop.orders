package com.ashoporders.messaging.consumer.impl;

import com.ashoporders.messaging.consumer.MessageListener;
import com.ashoporders.model.dto.CreateOrderRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumerImpl implements MessageListener {

    private final String changeOrdersStatusTopic = "change_orders_status";
    private final String groupId = "change_status_order_group";

    @Override
    @KafkaListener(topics = changeOrdersStatusTopic, groupId = groupId)
    public void listenMessage(CreateOrderRequestDto createOrderRequestDto) throws MessagingException {
            log.info("Changed orders status. Order id:{}, status:{}", createOrderRequestDto.getOrderId(), createOrderRequestDto.getStatus());
    }
}
