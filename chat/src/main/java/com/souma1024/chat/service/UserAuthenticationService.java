package com.souma1024.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souma1024.chat.repository.UserRepository;
import com.souma1024.chat.dto.UserSignupRequest;
import com.souma1024.chat.model.User;

import java.util.*;

@Service
public class UserAuthenticationService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserbyLoginId(UserSignupRequest request) {
        Optional<User> user = userRepository.findByLoginId(request.getLoginId());
        if(!user.isPresent()) {
            return null;
        }
        return user;
    }

}
