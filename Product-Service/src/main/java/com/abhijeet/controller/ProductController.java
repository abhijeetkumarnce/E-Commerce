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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public Product getOneProductById(@PathVariable Long productId){
        return productService.getOneProductById(productId);
    }

    @RequestMapping(value = "/{productName}", method = RequestMethod.GET)
    public Product getOneProductByName(@PathVariable String productName){
        return productService.getOneProductByName(productName);
    }

    @RequestMapping(value = "/{productRating}", method = RequestMethod.GET)
    public List<Product> getAllProductsByRating(@PathVariable double productRating){
        return productService.getAllProductsByRating(productRating);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Product saveNewProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
}
