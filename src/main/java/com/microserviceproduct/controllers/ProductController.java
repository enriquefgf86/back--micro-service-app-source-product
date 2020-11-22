package com.microserviceproduct.controllers;


import com.microserviceproduct.entities.Products;
import com.microserviceproduct.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    Environment environment;//variable para acceder al application properties

    @Autowired
    ProductService productService;

    @Autowired
    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping(value = "/product/list")
    public List<Products> getAllProducts() {

        List<Products> allProducts = productService.findAllProducts().stream().map(products -> {
//            products.setPortServer(Integer.parseInt(environment.getProperty("local.server.port"))); en caso de que se use Environment
            products.setPortServer(serverPort);
            return products;
        }).collect(Collectors.toList());
        return allProducts;
    }//extrayendose el listrado de productos desde ambas instancias por ribbon, ademas de establecerse el puerto
    //que ribbon establece por balanceo., a traves del acceso del map estableciendose el por server para cada request
    //dentro del loop

    @GetMapping(value = "/product/detail/{productId}")
    public Products getAProduct(@PathVariable("productId") Long productId) {
        Products products = productService.getProductById(productId);
//        products.setPortServer(Integer.parseInt(environment.getProperty("local.server.port")));
        products.setPortServer(serverPort);
        return products;
    }//enb este caso se sigue el mismo proceso que el anterior aunque no es necesario iterar de ahi
    //que se establezca la logica soibre el producto traido segun su id
}
