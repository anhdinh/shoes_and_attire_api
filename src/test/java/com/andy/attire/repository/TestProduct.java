package com.andy.attire.repository;

import com.andy.attire.dto.mapper.ProductMapper;
import com.andy.attire.entity.ProductEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;

@DisplayName("Product Test Repository")
@SpringBootTest
public class TestProduct {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional
    @Rollback(value = true)
    public void testInsert() {
        List<ProductEntity> list = IntStream.rangeClosed(1, 40).mapToObj(i -> {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setTitle("product number" + i);
            productEntity.setCategory("lifestyle");
            productEntity.setRating(randomRating(0, 5));
            productEntity.setPrice(new BigDecimal(150));
            productEntity.setThumbnail("../assets/images/shoe-5.png");
            productEntity.setBrand("lifestyle");
            productEntity.setStock(100);
            productEntity.setDescription("this is test product");
            productEntity.setDiscountPercentage(randomRating(0, 100));
            return productEntity;
        }).toList();
        productRepository.saveAll(list);
    }

    @Test
    @Transactional
    public void testConvertProductToDto() {
        var product = productRepository.getReferenceById(1L);
        var dto = ProductMapper.convertToDto(product);
        dto.getImages().forEach(System.out::println);
        var rt = product.getRating();
        System.out.println(rt);
    }


    @Test
    @DisplayName("Product has a list of image")
    public void testGetSingleProduct() {
        var product = productRepository.getSingleProductById(1L);
        assertThat(product, instanceOf(ProductEntity.class));
        assertThat(product.getImages(), hasSize(4));

    }

    @Test
    @DisplayName("Test sort product by name")
    public void testSortProductByName() {
        Page<ProductEntity> productEntities = productRepository.findAll(PageRequest.of(1, 12).withSort(Sort.by(Sort.Direction.ASC, "id")));
        productEntities.stream().map(ProductEntity::getTitle).forEach(System.out::println);
    }

    public static double randomRating(double rangeMin, double rangeMax) {
        Random r = new Random();
        return rangeMin + (rangeMax - rangeMin) * r.nextDouble();
    }

}
