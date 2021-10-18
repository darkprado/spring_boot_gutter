package com.example.spring_boot_gutter.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("test")
@RestController
public class WebApp {

    @Value("${spring.info:info}")
    private String info;

    @GetMapping("/")
    public String welcome() {
        return info;
    }

}
