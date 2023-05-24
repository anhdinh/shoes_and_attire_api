package com.andy.attire.repository;

import com.andy.attire.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
public class TestProduct {

    @Autowired
    private ProductRepository productRepository;

    //@Test
    public void testInsert(){
       List<ProductEntity> list =  IntStream.rangeClosed(1,40).mapToObj(i->{
            ProductEntity productEntity =  new ProductEntity();
            productEntity.setTitle("product number"+i);
            productEntity.setCategory("lifestyle");
            productEntity.setRating(randomRating(0,5));
            productEntity.setPrice(new BigDecimal(150));
            productEntity.setThumbnail("../assets/images/shoe-5.png");
            productEntity.setBrand("lifestyle");
            productEntity.setStock(100);
            productEntity.setDescription("this is test product");
            productEntity.setDiscountPercentage(randomRating(0,100));
            return productEntity;
        }).toList();

       productRepository.saveAll(list);
    }

    public static  double randomRating(double rangeMin, double rangeMax){
        Random r = new Random();
        return rangeMin + (rangeMax - rangeMin) * r.nextDouble();
    }




}
