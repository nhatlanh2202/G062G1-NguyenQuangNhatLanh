package com.codegym.controller;


import com.codegym.entity.MailBox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mail")
public class MailBoxController {
    @GetMapping
    public String getMailPage(Model model){
        model.addAttribute("home_mail", new MailBox());
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        model.addAttribute("languages", languages);
        List<Integer> pageSize = new ArrayList<>();
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);
        model.addAttribute("pageSize", pageSize);
        return "/home_mail";
    }

    @PostMapping
    public String getUpdate(@ModelAttribute MailBox mailBox, Model model){
            model.addAttribute("result_mail", mailBox);
            List<String> languages = new ArrayList<>();
            languages.add("English");
            languages.add("Vietnamese");
            languages.add("Japanese");
            languages.add("Chinese");
            model.addAttribute("languages", languages);
            List<Integer> pageSize = new ArrayList<>();
            pageSize.add(5);
            pageSize.add(10);
            pageSize.add(15);
            pageSize.add(25);
            pageSize.add(50);
            pageSize.add(100);
            model.addAttribute("pageSize", pageSize);
            return "/result_mail";
    }
}
