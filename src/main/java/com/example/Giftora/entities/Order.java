package com.example.Giftora.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long productId;
    private LocalDateTime orderDate;
    private String status;

    public Order(){}
    public Order(Long userId, Long productId, LocalDateTime orderDate, String status){
        this.userId=userId; this.productId=productId;
        this.orderDate=orderDate; this.status=status;
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId=userId; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId=productId; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate=orderDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status=status; }
}