package com.ffmusic.controller;


import com.ffmusic.entity.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@CrossOrigin
public class defaultController {
    @GetMapping
    public String hello() {
        User user = new User();
        return "欢迎使用ffMusic";
    }
}
