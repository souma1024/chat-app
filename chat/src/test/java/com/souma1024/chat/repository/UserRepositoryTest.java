package com.souma1024.chat.repository;

import com.souma1024.chat.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveAndFindUser() {
        User testUser = new User();
        testUser.setLoginId("test123");
        testUser.setPassword("testPassword");
        testUser.setUsername("testUsername");

        User savedUser = userRepository.save(testUser);

        User foundUser = userRepository.findById(savedUser.getId()).orElse(null);
        assertNotNull(foundUser);
        assertEquals("test123", foundUser.getLoginId());
        assertEquals("testUsername", foundUser.getUsername());
    }
}
