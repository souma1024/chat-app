package com.souma1024.chat.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.souma1024.chat.repository.UserRepository;
import com.souma1024.chat.model.User;

import java.util.Optional;

@Service
public class LoginUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public LoginUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        Optional<User> _user = userRepository.findByLoginId(loginId);
        return _user.map(user -> new LoginUserDetails(user))
            .orElseThrow(() -> new UsernameNotFoundException("not found userID=" + loginId));
        
    }
}
