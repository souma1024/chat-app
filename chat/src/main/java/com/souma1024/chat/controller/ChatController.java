package com.souma1024.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class ChatController {
    @GetMapping("/chat")
    public String showChatPage() {
        return "chat";
    }
}
