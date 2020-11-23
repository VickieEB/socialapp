package com.petproject.socialapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HomeController {
    @GetMapping("/welcome")
    public String index(){
        return "Welcome to Social Page";
    }
}
