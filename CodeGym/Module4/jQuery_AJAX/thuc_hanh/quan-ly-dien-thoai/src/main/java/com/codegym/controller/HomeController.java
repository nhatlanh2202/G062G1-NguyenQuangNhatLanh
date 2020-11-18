package com.codegym.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
public class HomeController {
    @GetMapping("/")
    public String showIndex(){
        return "index";
    }
}
