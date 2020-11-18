package com.codegym.controllers;

import com.codegym.entity.AppUser;
import com.codegym.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes(value = "userLogin")
@RequestMapping({"", "/login"})
public class LoginController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping({"", "/login"})
    public String goLogin() {
        return "login";
    }

    @GetMapping("/403")
    public String go403() {
        return "403";
    }

    @GetMapping("/register")
    public String goRegister(Model model){
        model.addAttribute("newAccount", new AppUser());
        return "register";
    }

    @PostMapping("/newRegister")
    public String newRegister(@ModelAttribute AppUser appUser, @RequestParam("role") Long[] role){
        appUser.setEncrytedPassword(bCryptPasswordEncoder.encode(appUser.getEncrytedPassword()));
        this.userDetailsService.saveNewUser(appUser);
        for (Long appRole : role){
            this.userDetailsService.saveUserRole(appUser, appRole);
        }
        return "redirect:/register";
    }
}

