package com.microserviceproduct.services;

import com.microserviceproduct.entities.Products;

import java.util.List;

public interface ProductService {

    public List<Products> findAllProducts();
    public Products getProductById(Long productId);
}
