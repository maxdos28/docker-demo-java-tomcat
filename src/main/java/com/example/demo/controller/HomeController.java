package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Hello World from Spring Boot!");
        return "index";
    }
    
    @GetMapping("/api/health")
    @ResponseBody
    public String health() {
        return "OK";
    }
}