package com.ashoporders.controller;

import com.ashoporders.messaging.producer.MessageProducer;
import com.ashoporders.model.dto.CreateOrderRequestDto;
import com.ashoporders.model.entity.Order;
import com.ashoporders.repository.OrderRepository;
import com.ashoporders.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrdersController {

    private final OrderService orderService;

    @PutMapping("/createOrder")
    public ResponseEntity<String> createOrder(@RequestBody CreateOrderRequestDto createOrderRequestDto) {
        orderService.registerOrder(createOrderRequestDto);
        return ResponseEntity.ok().body("Order added successfully");
    }
}
