package com.shop.product.service;


import com.shop.product.document.Product;
import com.shop.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public Product findById(String id) {
        return productRepository.findById(id).get();
    }
    public Product create(Product product) {
        return productRepository.save(product);
    }
    public void delete(String id) {
        productRepository.deleteById(id);
    }
    public void deleteAll(){
        productRepository.deleteAll();
    }
    public Optional<Product> update(Product product, String id) {
        return productRepository.findById(id)
                .map(existProduct ->{
                    if(product.getName() != null){
                        existProduct.setName(product.getName());
                    }
                    if(product.getColor() != null){
                        existProduct.setColor(product.getColor());
                    }
                    if(product.getPrice() != null){
                        existProduct.setPrice(product.getPrice());
                    }
                    if(product.getQuantity() != 0){
                        existProduct.setQuantity(product.getQuantity());
                    }
                    if(product.getDescription() != null){
                        existProduct.setDescription(product.getDescription());
                    }
                    return productRepository.save(existProduct);
                });

    }

    public Product findByName(String name){
        return productRepository.findByName(name);
    }

}
