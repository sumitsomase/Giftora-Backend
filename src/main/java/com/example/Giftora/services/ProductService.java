package com.example.Giftora.services;

import com.example.Giftora.entities.Product;
import com.example.Giftora.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    // Save new product
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    // Get all products
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    // Get products by seller ID
    public List<Product> getProductsBySeller(Long sellerId){
        return productRepository.findBySellerId(sellerId);
    }

    // Get products by category
    public List<Product> getProductsByCategory(String category){
        return productRepository.findByCategory(category);
    }

    // Get product by ID
    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    // Delete product
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}