package com.ashoporders.controller;

import com.ashoporders.model.dto.CreateOrderRequestDto;
import com.ashoporders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrdersController {

    private final OrderService orderService;

    @PostMapping("/createOrder")
    public ResponseEntity<String> createOrder(@RequestBody CreateOrderRequestDto createOrderRequestDto) {
        orderService.registerOrder(createOrderRequestDto);
        return ResponseEntity.ok().body("Order added successfully");
    }
}
