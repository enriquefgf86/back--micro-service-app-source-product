package com.microserviceproduct.servicesImpl;

import com.microserviceproduct.entities.Products;
import com.microserviceproduct.repositories.ProductRepository;
import com.microserviceproduct.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Products> findAllProducts() {
        List<Products>productsList=productRepository.findAll();
        return productsList;
    }

    @Override
    public Products getProductById(Long productId) {
        Products product=productRepository.findById(productId).orElse(null);
        return product;

    }
}
