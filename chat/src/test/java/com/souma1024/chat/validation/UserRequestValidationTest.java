package com.souma1024.chat.validation;


import jakarta.validation.Validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRequestValidationTest {
    
    @Autowired
    private Validator validator;



}
