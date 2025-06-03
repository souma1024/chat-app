package com.souma1024.chat.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.souma1024.chat.security.LoginUserDetails;

public class AuthUtil {
    
    public static LoginUserDetails getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof LoginUserDetails) {
            return (LoginUserDetails) principal;
        } else {
            return null;
        }
        
    }

}
