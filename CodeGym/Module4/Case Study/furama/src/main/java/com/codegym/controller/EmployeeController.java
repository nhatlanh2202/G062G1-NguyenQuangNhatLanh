package com.codegym.controller;


import com.codegym.entity.Customer;
import com.codegym.entity.Employee;
import com.codegym.service.DivisionService;
import com.codegym.service.EducationService;
import com.codegym.service.EmployeeService;
import com.codegym.service.PositionService;
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



@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private EducationService educationService;

    @Autowired
    private PositionService positionService;

    @GetMapping
    public ModelAndView listEmployee(@PageableDefault(value = 3) Pageable pageable,
                                     @RequestParam(value = "search", defaultValue = "") String search) {
        ModelAndView modelAndView = new ModelAndView("employee/listEmployee");
        Page<Employee> employees = employeeService.findAll(search, pageable);
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("search", search);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("employee/createEmployee");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("division", divisionService.findAll());
        modelAndView.addObject("educationDegree",educationService.findAll());
        modelAndView.addObject("position",positionService.findAll());
        return modelAndView;
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("division", divisionService.findAll());
            model.addAttribute("educationDegree", educationService.findAll());
            model.addAttribute("position", positionService.findAll());
            return "employee/createEmployee";
        }
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("success","saved employee successfully!");
        return "redirect:/employee";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable String id){
        Employee employee = employeeService.findById(id);
        if (employee != null){
                ModelAndView modelAndView = new ModelAndView("employee/editEmployee");
                modelAndView.addObject("employee", employee);
                modelAndView.addObject("division",divisionService.findAll());
                modelAndView.addObject("educationDegree",educationService.findAll());
                modelAndView.addObject("position",positionService.findAll());
                return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes){
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("success","Modified employee successfully");
        return "redirect:/employee";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteForm(@PathVariable String id){
        Employee employee = employeeService.findById(id);
        if(employee != null) {
            ModelAndView modelAndView = new ModelAndView("employee/deleteEmployee");
            modelAndView.addObject("employee", employee);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete")
    public String deleteEmployee(@ModelAttribute("customer") Employee employee,RedirectAttributes redirectAttributes){
        employeeService.remove(employee.getId());
        redirectAttributes.addFlashAttribute("success", "Deleted employee successfully!");
        return "redirect:/employee";
    }
}
