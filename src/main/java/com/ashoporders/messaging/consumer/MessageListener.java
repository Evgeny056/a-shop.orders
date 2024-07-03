package com.ashoporders.messaging.consumer;

import com.ashoporders.model.dto.CreateOrderRequestDto;
import org.springframework.messaging.MessagingException;

public interface MessageListener {
    void listenMessage(CreateOrderRequestDto createOrderRequestDto) throws MessagingException;
}
