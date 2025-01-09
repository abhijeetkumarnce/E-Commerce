package com.abhijeet.controller;

import com.abhijeet.entities.Product;
import com.abhijeet.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/id/{productId}")
    public Product getOneProductById(@PathVariable Long productId){
        return productService.getOneProductById(productId);
    }

    @GetMapping("/name/{productName}")
    public Product getOneProductByName(@PathVariable String productName){
        return productService.getOneProductByName(productName);
    }

    @GetMapping("/rating/{productRating}")
    public List<Product> getAllProductsByRating(@PathVariable double productRating){
        return productService.getAllProductsByRating(productRating);
    }

    @PostMapping("/")
    public Product saveNewProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
}
