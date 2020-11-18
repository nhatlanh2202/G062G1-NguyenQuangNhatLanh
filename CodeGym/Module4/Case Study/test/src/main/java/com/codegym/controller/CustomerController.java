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
import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private TypeCustomerService typeCustomerService;

//    @GetMapping
//    public ModelAndView listCustomer(@PageableDefault(value = 3) Pageable pageable,
//                                     @RequestParam(value = "search", defaultValue = "") Optional<String> search) {
//        ModelAndView modelAndView = new ModelAndView("customer/listCustomer");
//        String searchOld="";
//        if (search.isPresent()){
//            searchOld= search.get();
//            Page<Customer> customer1 = customerService.findAllByAllName(searchOld,pageable);
//            modelAndView.addObject("customers", customer1);
//        }else {
//            Page<Customer> customers = customerService.findAll(pageable);
//            modelAndView.addObject("customers", customers);
//        }
//        modelAndView.addObject("searchOld", searchOld);
//        return modelAndView;
//    }

    @GetMapping
    public ModelAndView listCustomer(@PageableDefault(value = 3) Pageable pageable,
                                     @RequestParam(value = "searchName", defaultValue = "") String searchName,
                                     @RequestParam(value = "searchAddress", defaultValue = "") String searchAddress,
                                     @RequestParam(value = "searchEmail", defaultValue = "") String searchEmail) {
        Page<Customer> customers = null;
        if (searchName.equals("") && searchAddress.equals("") && searchEmail.equals("")) {
            customers = customerService.findAll(pageable);
        } else if (searchAddress.equals("") && searchEmail.equals("")) {
            customers = customerService.findAllByNameContaining(searchName, pageable);
        } else if (searchName.equals("") && searchAddress.equals("")) {
            customers = customerService.findAllByEmailContaining(searchEmail, pageable);
        } else if (searchName.equals("") && searchEmail.equals("")) {
            customers = customerService.findAllByAddressContaining(searchAddress, pageable);
        } else if (searchEmail.equals("")){
            customers = customerService.findAllByNameContainingAndAddressContaining(searchName, searchAddress, pageable);
        } else if (searchAddress.equals("")){
            customers = customerService.findAllByNameContainingAndEmailContaining(searchName,searchEmail,pageable);
        } else if (searchName.equals("")){
            customers = customerService.findAllByAddressContainingAndEmailContaining(searchAddress, searchEmail, pageable);
        } else {
            customers = customerService.findAllByNameContainingAndAddressContainingAndEmailContaining(searchName,
                    searchAddress, searchEmail, pageable);
        }
        ModelAndView modelAndView = new ModelAndView("customer/listCustomer");
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("searchName", searchName);
        modelAndView.addObject("searchAddress", searchAddress);
        modelAndView.addObject("searchEmail", searchEmail);
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
        redirectAttributes.addFlashAttribute("success", "saved customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable String id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("customer/editCustomer");
            modelAndView.addObject("customer", customer);
            modelAndView.addObject("customerType", typeCustomerService.findAll());
            return modelAndView;

        } else {
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
    public ModelAndView showDeleteForm(@PathVariable String id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("customer/deleteCustomer");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("success", "Deleted customer successfully!");
        return "redirect:/customer";
    }
}
