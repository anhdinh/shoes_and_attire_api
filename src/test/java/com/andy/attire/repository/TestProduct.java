package com.andy.attire.repository;

import com.andy.attire.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@SpringBootTest
public class TestProduct {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testInsert(){
        ProductEntity productEntity =  new ProductEntity();
        productEntity.setTitle("mens shoes dn 23xx, new product");
        productEntity.setCategory("lifestyle");
        productEntity.setRating(randomRating(0,5));
        productEntity.setTitle("test product");
        this.productRepository.save(productEntity);
    }

    public static  double randomRating(double rangeMin, double rangeMax){
        Random r = new Random();
        return rangeMin + (rangeMax - rangeMin) * r.nextDouble();
    }

    @Test
    public void testGetProducts(){
      Optional<List<ProductEntity>> productEntityList =   productRepository.getProducts(0,5);
      productEntityList.ifPresent(System.out::println);
    }


}
