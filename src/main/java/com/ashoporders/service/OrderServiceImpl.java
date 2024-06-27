package com.ashoporders.service;

import com.ashoporders.mapper.OrderMapper;
import com.ashoporders.messaging.producer.MessageProducer;
import com.ashoporders.model.dto.CreateOrderRequestDto;
import com.ashoporders.model.entity.Order;
import com.ashoporders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MessageProducer<CreateOrderRequestDto> messageProducer;
    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public void registerOrder(CreateOrderRequestDto createOrderRequestDto) {
        Order order = orderMapper.toEntity(createOrderRequestDto);
        Order savedOrder = orderRepository.save(order);
        CreateOrderRequestDto savedOrderRequestDto = orderMapper.toDto(savedOrder); //дописать dto для kafka
        messageProducer.sendMessage(savedOrderRequestDto);
    }
}
