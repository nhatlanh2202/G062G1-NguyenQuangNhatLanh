package com.codegym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"", "/login"})
public class LoginController {

    @GetMapping
    public String goLogin() {
        return "login";
    }

    @GetMapping("/403")
    public String go403() {
        return "403";
    }
}
