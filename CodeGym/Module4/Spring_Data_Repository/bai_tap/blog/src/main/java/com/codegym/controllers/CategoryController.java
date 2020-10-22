package com.codegym.controllers;

import com.codegym.model.Category;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listCategory(Model model){
        model.addAttribute("category",categoryService.findAll());
        return "category/list-category";
    }
    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("category",new Category());

        return "category/create-category";
    }
    @PostMapping("/save")
    public String save(Category category, RedirectAttributes redirect) {
        categoryService.save(category);
        redirect.addFlashAttribute("success", "Saved category successfully!");
        return "redirect:/category";
    }


    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/category-edit";
    }

    @PostMapping("/update")
    public String update(Category category, RedirectAttributes redirect) {
        categoryService.update(category);
        redirect.addFlashAttribute("success", "Modified category successfully!");
        return "redirect:/category";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/category-delete";
    }

    @PostMapping("/delete")
    public String delete(Category category, RedirectAttributes redirect) {
        categoryService.remove(category);
        redirect.addFlashAttribute("success", "Removed category successfully!");
        return "redirect:/category";
    }

}
