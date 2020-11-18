package com.codegym.controller;


import com.codegym.entity.Customer;
import com.codegym.entity.Services;
import com.codegym.service.RentTypeService;
import com.codegym.service.ServiceService;
import com.codegym.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/services")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @Autowired
    private RentTypeService rentTypeService;


    @GetMapping
    public ModelAndView listService(@PageableDefault(value = 3) Pageable pageable,
                                     @RequestParam(value = "search", defaultValue = "") String search) {
        ModelAndView modelAndView = new ModelAndView("service/listService");
        Page<Services> services = serviceService.findAll(search, pageable);
        modelAndView.addObject("service", services);
        modelAndView.addObject("search", search);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("service/createService");
        modelAndView.addObject("service", new Services());
        modelAndView.addObject("rentType", rentTypeService.findAll());
        modelAndView.addObject("serviceType", serviceTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveService(@Valid @ModelAttribute Services service, BindingResult result,
                              RedirectAttributes redirectAttributes, Model model){
        if (result.hasFieldErrors()){
            FieldError a = result.getFieldError();
            model.addAttribute("rentType",rentTypeService.findAll());
            model.addAttribute("serviceType",serviceTypeService.findAll());
            return "service/createService";
        }
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("success", "Saved Service successfully!");
        return "redirect:/services";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditFormService(@PathVariable String id){
        Services service = serviceService.findById(id);
        if(service != null) {
            ModelAndView modelAndView = new ModelAndView("service/editService");
            modelAndView.addObject("service", service);
            modelAndView.addObject("rentType",rentTypeService.findAll());
            modelAndView.addObject("serviceType",serviceTypeService.findAll());
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/update")
    public String updateService(@ModelAttribute Services service, RedirectAttributes redirectAttributes) {
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("success", "Modified service successfully!");
        return "redirect:/services";
    }


    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteFormService(@PathVariable String id){
        Services service = serviceService.findById(id);
        if(service != null) {
            ModelAndView modelAndView = new ModelAndView("service/deleteService");
            modelAndView.addObject("service", service);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }
    @PostMapping("/delete")
    public String deleteService(@ModelAttribute("service") Services service,RedirectAttributes redirectAttributes){
        serviceService.remove(service.getIdService());
        redirectAttributes.addFlashAttribute("success", "Deleted service successfully!");
        return "redirect:/services";
    }
}
