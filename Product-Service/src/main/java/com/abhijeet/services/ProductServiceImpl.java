package com.abhijeet.services;

import com.abhijeet.entities.Product;
import com.abhijeet.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getOneProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product Not Found...!!!"));
    }

    @Override
    public Product getOneProductByName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public List<Product> getAllProductsByRating(double productRating) {
        return productRepository.findByProductRating(productRating);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
