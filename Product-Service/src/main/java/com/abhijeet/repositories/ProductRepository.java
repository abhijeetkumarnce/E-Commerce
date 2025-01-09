package com.abhijeet.repositories;

import com.abhijeet.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductRating(double productRating);

    Product findByProductName(String productName);
}
