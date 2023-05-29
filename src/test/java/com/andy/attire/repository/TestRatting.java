package com.andy.attire.repository;

import com.andy.attire.entity.RattingEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@DisplayName("Product Test Repository")
@SpringBootTest
public class TestRatting {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RattingRepository rattingRepository;

    @Test
    public void testInsert(){
        String user_id = "0d31ecf2-6a7d-4bcd-bad4-8a02273eb0ab";
        var product = productRepository.getSingleProductById(1L);
        var user = userRepository.findById(UUID.fromString(user_id));
        RattingEntity rattingEntity =  new RattingEntity();
        rattingEntity.setVote(4);
        rattingEntity.setUser(user.get());
        rattingEntity.setProduct(product);
        rattingRepository.save(rattingEntity);
    }
}
