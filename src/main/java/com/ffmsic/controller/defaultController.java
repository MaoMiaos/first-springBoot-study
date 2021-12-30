package com.ffmsic.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class defaultController {
    @GetMapping
    public String hello(){
        return "欢迎使用ffMusic";
    }
}
