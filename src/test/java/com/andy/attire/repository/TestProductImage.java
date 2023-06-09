package com.andy.attire.repository;

import com.andy.attire.entity.ProductImageEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest

public class TestProductImage {
    private final ProductImageRepository imageRepository;
    private final ProductRepository productRepository;

    @Autowired
    public TestProductImage(ProductImageRepository imageRepository, ProductRepository productRepository) {
        this.imageRepository = imageRepository;
        this.productRepository = productRepository;
    }

    @Test
    @Transactional
    @Rollback
    public void testInsert() {
        var product = productRepository.getReferenceById(1L);
        ProductImageEntity imageEntity = new ProductImageEntity();
        imageEntity.setUrl("./assets/shoes_images/shoe_4.jpg");
        imageEntity.setProduct(product);
        imageRepository.save(imageEntity);
    }

    @Test
    public void testGetProductByImage() {
        var image = imageRepository.findById(1L);
        if (image.isPresent()) {
            var product = image.get().getProduct();
            System.out.println(product.getTitle());
        }
    }

    @Test
    @Transactional
    public void testGetImagesByProduct() {
        var product = productRepository.findById(1L);
        if (product.isPresent()) {
           var images = product.get().getImages();
           images.forEach(System.out::println);
        }
    }

    @Test
    public void testGetCount(){
        var sqlMapping = imageRepository.usingSqlResultSetMapping(1L);
        var projection = imageRepository.countInterfaceProjection(1L);
        var directToDto = imageRepository.directMappingToDto(1L);
        var tuple= imageRepository.findByUsingTuple(1L);
        System.out.println(sqlMapping);
        System.out.println("----------");
        System.out.println("projection count :"+projection.getCount());
        System.out.println("-----------");
        System.out.println(directToDto);
        System.out.println("----------");
        System.out.println(tuple.get(0,Long.class));
        System.out.println(tuple.get(1,String.class));
    }
}
