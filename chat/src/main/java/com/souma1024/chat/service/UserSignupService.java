package com.souma1024.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.souma1024.chat.dto.UserSignupRequest;
import com.souma1024.chat.model.User;
import com.souma1024.chat.repository.UserRepository;

import java.util.List;

@Service
public class UserSignupService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserSignupService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> searchAll() {
        return userRepository.findAll();
    }

    public void UserRegister(UserSignupRequest userSignupRequest) {
        User user = new User();
        user.setLoginId(userSignupRequest.getLoginId());
        user.setUsername(userSignupRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userSignupRequest.getPassword()));

        userRepository.save(user);
    }

}
