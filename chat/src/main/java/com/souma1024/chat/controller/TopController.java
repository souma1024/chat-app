package com.souma1024.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping
public class TopController {
    
    @GetMapping("/")
    public String getMethodName() {
        return "top";
    }
}
