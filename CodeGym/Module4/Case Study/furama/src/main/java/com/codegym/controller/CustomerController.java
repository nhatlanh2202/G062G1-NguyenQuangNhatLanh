package com.codegym.controller;


import com.codegym.entity.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.TypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private TypeCustomerService typeCustomerService;

    @GetMapping
    public ModelAndView listCustomer(@PageableDefault(value = 3) Pageable pageable,
                                     @RequestParam(value = "search", defaultValue = "") String search) {
        ModelAndView modelAndView = new ModelAndView("customer/listCustomer");
        Page<Customer> customers = customerService.findAll(search, pageable);
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("search", search);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("customer/createCustomer");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customerType", typeCustomerService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerType", typeCustomerService.findAll());
            return "customer/createCustomer";
        }
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success","saved customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable String id){
        Customer customer = customerService.findById(id);
        if(customer != null) {
            ModelAndView modelAndView = new ModelAndView("customer/editCustomer");
            modelAndView.addObject("customer", customer);
            modelAndView.addObject("customerType",typeCustomerService.findAll());
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/customer";
    }


    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteForm(@PathVariable String id){
        Customer customer = customerService.findById(id);
        if(customer != null) {
            ModelAndView modelAndView = new ModelAndView("customer/deleteCustomer");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer,RedirectAttributes redirectAttributes){
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("success", "Deleted customer successfully!");
        return "redirect:/customer";
    }
}
