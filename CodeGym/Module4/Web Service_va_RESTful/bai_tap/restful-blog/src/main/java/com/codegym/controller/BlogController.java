package com.codegym.controller;


import com.codegym.entity.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller

@RequestMapping({"/blog",""})
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping
    public String goHomeBlog(Model model){
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "/index";
    }

    @GetMapping("/create")
    public String goCreateBlog(Model model){
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        this.blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "create blog OK !");
        return "redirect:/blog";
    }

    @GetMapping("/blog/update")
    public String goUpdateBlog(Model model, @RequestParam String id){
        model.addAttribute("blog", this.blogService.findById(id));
        return "edit";
    }

    @PostMapping("/blog/editBlog")
    public String updateBlog(@ModelAttribute Blog blog){
        this.blogService.edit(blog);
        return "redirect:/";
    }

    @GetMapping("/view")
    public String viewBlog(@RequestParam String id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/view";
    }


    @GetMapping("/blog/delete")
    public String delete(@RequestParam String id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "/delete";
    }

    @PostMapping("/blog/delete")
    public String delete(Blog blog, RedirectAttributes redirect){
        blogService.delete(blog.getId());
        redirect.addFlashAttribute("success","Removed blog successfully!");
        return "redirect:/";
    }
}
