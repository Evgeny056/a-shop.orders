package com.ashoporders.service;

import com.ashoporders.exception.UserNotFoundException;
import com.ashoporders.mapper.OrderMapper;
import com.ashoporders.messaging.producer.MessageProducer;
import com.ashoporders.model.dto.CreateOrderRequestDto;
import com.ashoporders.model.entity.Order;
import com.ashoporders.model.entity.User;
import com.ashoporders.repository.OrderRepository;
import com.ashoporders.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MessageProducer<CreateOrderRequestDto> messageProducer;
    private final OrderMapper orderMapper;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void registerOrder(CreateOrderRequestDto createOrderRequestDto) {
        User user = userRepository.findById(createOrderRequestDto.getUserId())
                .orElseThrow(()-> new UserNotFoundException("User not found by Id: " + createOrderRequestDto.getUserId()));

        Order order = orderMapper.INSTANCE.toEntity(createOrderRequestDto);
        order.setUser(user);
        orderRepository.save(order);
        messageProducer.sendMessage(orderMapper.toDto(order));
    }
}
