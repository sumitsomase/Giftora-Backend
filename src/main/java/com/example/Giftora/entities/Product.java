package com.example.Giftora.entities;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private String category;
    private String description;
    private String imageURL;
    private Long sellerId;

    // Constructors
    public Product(){}
    public Product(String name, double price, String category, String description, String imageURL, Long sellerId){
        this.name=name; this.price=price; this.category=category;
        this.description=description; this.imageURL=imageURL; this.sellerId=sellerId;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name=name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price=price; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category=category; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description=description; }
    public String getImageURL() { return imageURL; }
    public void setImageURL(String imageURL) { this.imageURL=imageURL; }
    public Long getSellerId() { return sellerId; }
    public void setSellerId(Long sellerId) { this.sellerId=sellerId; }
}
