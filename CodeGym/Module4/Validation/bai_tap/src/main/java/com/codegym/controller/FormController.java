package com.codegym.controller;

import com.codegym.entity.RegisterForm;
import com.codegym.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping({"/create",""})
public class FormController {
    @Autowired
    private FormService formService;

    @GetMapping
    public String formCreate(Model model){
        model.addAttribute("registerForm", new RegisterForm());
        return "user/create";
    }

    @PostMapping("/create")
    public String createNewAccount(@Valid @ModelAttribute RegisterForm registerForm, BindingResult bindingResult,
                                   Model model){
        if (bindingResult.hasFieldErrors()){
            return "user/create";
        }else {
            formService.save(registerForm);
            model.addAttribute("ok","OK!!!!!!!!!!!");
            return "user/result";
        }
    }
}
