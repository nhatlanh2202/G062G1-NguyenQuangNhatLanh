package com.codegym.controller;


import com.codegym.entity.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/customer", ""})
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String goListCustomer(Model model) {
        model.addAttribute("listCustomer", customerService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String goCreateCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "create customer OK !");
        return "redirect:/customer";
    }

    @GetMapping("/customer/update")
    public String goUpdateCustomer(Model model, @RequestParam Integer id){
        model.addAttribute("customer", this.customerService.findById(id));
        return "edit";
    }

    @PostMapping("/customer/update")
    public String updateCustomer(@RequestParam Customer customer){
        this.customerService.save(customer);
        return "redirect:/";
    }


    @GetMapping("/customer/delete")
    public String delete(@RequestParam Integer id, Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "/delete";
    }

    @PostMapping("/customer/delete")
    public String delete(Customer customer, RedirectAttributes redirect){
        customerService.delete(customer.getId());
        redirect.addFlashAttribute("success","Removed customer successfully!");
        return "redirect:/";
    }
}
