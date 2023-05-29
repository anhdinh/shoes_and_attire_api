package com.andy.attire.repository;

import com.andy.attire.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Date;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


@DisplayName("User Test Repository")
@SpringBootTest
@Transactional
public class TestUser {

    @Autowired
    UserRepository userRepository;

    @DisplayName("test inserting user")
    @Test
    public void insertTest() {
        UserEntity user = new UserEntity();
        user.setEmail("test@test.com");
        user.setUsername("test_user");
        user.setCreateDate(new Date());
        user.setPassword(BCrypt.hashpw("test@12345", BCrypt.gensalt()));
        UserEntity u = userRepository.save(user);
        System.out.println(u.getEmail());
    }

    @Test
    public void findUserByIdTest() {
        String user_id = "0d31ecf2-6a7d-4bcd-bad4-8a02273eb0ab";
        var user = userRepository.findById(UUID.fromString(user_id));
        assertThat(user.get().getId().toString(), is(user_id));
    }


}
