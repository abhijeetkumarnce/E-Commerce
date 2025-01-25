package com.abhijeet.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT_SERVICE")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String productDescription;
    private double productRating;

    public Product() {
    }

    public Product(Long productId, String productName, String productDescription, double productRating) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productRating = productRating;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductRating() {
        return productRating;
    }

    public void setProductRating(double productRating) {
        this.productRating = productRating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productRating=" + productRating +
                '}';
    }
}
