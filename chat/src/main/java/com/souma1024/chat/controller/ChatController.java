package com.souma1024.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import com.souma1024.chat.model.User;

@Controller
@RequestMapping
public class ChatController {
    @GetMapping("/chat")
    public String showChatPage(HttpSession session, Model model) {

        User loginUser = (User)session.getAttribute("loginUser");

        if (loginUser == null) {
            return "redirect:/login";
        }

        return "chat";
    }
}
