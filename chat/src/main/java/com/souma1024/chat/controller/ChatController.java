package com.souma1024.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.souma1024.chat.security.LoginUserDetails;
import com.souma1024.chat.util.AuthUtil;

@Controller
@RequestMapping
public class ChatController {
    @GetMapping("/chat")
    public String showChatPage(Model model) {
        LoginUserDetails userDetails = AuthUtil.getCurrentUser();

        if (userDetails != null) {
            model.addAttribute("loginId", userDetails.getLoginId());
            model.addAttribute("username", userDetails.getUsername());
        }

        return "chat";
    }
}
