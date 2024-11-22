package com.shop.product.controller;


import com.shop.product.document.Product;
import com.shop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getproduct() {
        return productService.findAll();
    }

    @PostMapping
    public String addProduct(@RequestBody Product product){
        productService.create(product);
        return "the product is added successfuly";
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id){
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductByID(@PathVariable String id){
        productService.delete(id);
    }

    @DeleteMapping
    public void deletAllproduct(){
        productService.deleteAll();
    }

    @PatchMapping("/{id}")
    public Optional<Product> update (@PathVariable String id, @RequestBody Product product){
        return productService.update(product, id);
    }

    @GetMapping("/{name}")
    public Product findproductByName(@PathVariable String name){
        return productService.findByName(name);
    }


}
