package com.souma1024.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.souma1024.chat.dto.UserSignupRequest;
import com.souma1024.chat.service.UserSignupService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping
public class SignupController {

    @Autowired
    private UserSignupService userSignupService;

    
    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }
    
    @PostMapping("/signup")
    public String resisterUser(@ModelAttribute UserSignupRequest request, RedirectAttributes redirectAttributes) {
        userSignupService.UserRegister(request);

        redirectAttributes.addFlashAttribute("complete", "新規登録が完了しました！！");
        return "redirect:/signup";
    }

}
