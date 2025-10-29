package com.example.Giftora.controllers;

import com.example.Giftora.entities.Order;
import com.example.Giftora.services.OrderService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin("*")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService){ this.orderService=orderService; }

    @PostMapping
    public Order createOrder(@RequestBody Order order){ return orderService.saveOrder(order); }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable Long userId){ return orderService.getOrdersByUser(userId); }
}
