package com.codegym.controllers;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
@RequestMapping({"/product", ""})
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public String index(Model model, RedirectAttributes redirect) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("products", productList);
        redirect.addFlashAttribute("success", "");

        return "/index";
    }

    @GetMapping("/product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/product/save")
    public String save(Product product, RedirectAttributes redirect) {
        productRepository.save(product);
        redirect.addFlashAttribute("success", "Saved product successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/{product_id}/edit")
    public String edit(@PathVariable Integer product_id, Model model) {
        model.addAttribute("product", productRepository.findById(product_id));
        return "/edit";
    }

    @PostMapping("/product/update")
    public String update(Product product, RedirectAttributes redirect) {
        productRepository.update(product);
        redirect.addFlashAttribute("success", "Modified product successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/{product_id}/delete")
    public String delete(@PathVariable Integer product_id, Model model) {
        model.addAttribute("product", productRepository.findById(product_id));
        return "/delete";
    }

    @PostMapping("/product/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productRepository.remove(product.getProduct_id());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/{product_id}/view")
    public String view(@PathVariable Integer product_id, Model model) {
        model.addAttribute("product", productRepository.findById(product_id));
        return "/view";
    }
}
