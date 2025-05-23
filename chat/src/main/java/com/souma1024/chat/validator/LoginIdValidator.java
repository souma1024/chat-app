package com.souma1024.chat.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.souma1024.chat.repository.UserRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class LoginIdValidator implements ConstraintValidator<ValidLoginId, String> {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String loginId, ConstraintValidatorContext context) {
        if (loginId == null || loginId.isBlank()) {
            return true;
        }
        return !userRepository.existsByLoginId(loginId);
    }

}
