package com.example.Giftora.services;

import com.example.Giftora.entities.Order;
import com.example.Giftora.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    // Save new order
    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    // Get all orders
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    // Get orders by user ID
    public List<Order> getOrdersByUser(Long userId){
        return orderRepository.findByUserId(userId);
    }

    // Get order by ID
    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }

    // Delete order
    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }
}