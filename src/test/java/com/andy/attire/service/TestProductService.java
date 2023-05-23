package com.andy.attire.service;

import com.andy.attire.dto.ProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestProductService {

    ProductService productService;

    @Autowired
    public TestProductService(ProductService productService){
        this.productService = productService;
    }



    @Test
    public void getProductById(){
       Optional<ProductDto> productDto =  productService.getSingleProductById(1L);
        Assertions.assertNotNull(productDto);
    }
}
