package com.abhijeet.services;

import com.abhijeet.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getOneProductById(Long productId);

    Product getOneProductByName(String productName);

    List<Product> getAllProductsByRating(double productRating);

    Product addProduct(Product product);

    void deleteProduct(Long productId);
}
