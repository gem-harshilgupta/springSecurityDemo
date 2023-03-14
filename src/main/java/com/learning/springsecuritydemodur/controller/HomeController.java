package com.learning.springsecuritydemodur.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {

    @GetMapping("/login")
    public String login(){
        return "Welcome to login page";
    }

    @GetMapping("/register")
    public String register(){
        return "Welcome to register page";
    }
}
