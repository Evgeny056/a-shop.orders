package com.ashoporders.service;

import com.ashoporders.model.dto.CreateOrderRequestDto;

public interface OrderService {
    void registerOrder(CreateOrderRequestDto createOrderRequestDto);
}
