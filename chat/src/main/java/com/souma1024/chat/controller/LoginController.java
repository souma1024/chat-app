package com.souma1024.chat.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.souma1024.chat.dto.UserSignupRequest;
import com.souma1024.chat.service.UserAuthenticationService;
import com.souma1024.chat.model.User;

@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login-process")
    public String authenticateUser(@ModelAttribute UserSignupRequest request, RedirectAttributes redirectAttributes) {
        Optional<User> user = userAuthenticationService.getUserbyLoginId(request);
        
        if(user.isEmpty()) {
            redirectAttributes.addFlashAttribute("failure", "アカウントが見つかりません");
            return "redirect:/login";
        } else if(!passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
            redirectAttributes.addFlashAttribute("failure", "パスワードが違います");
            return "redirect:/login";
        } else {
            return "chat";
        }
    }

}
