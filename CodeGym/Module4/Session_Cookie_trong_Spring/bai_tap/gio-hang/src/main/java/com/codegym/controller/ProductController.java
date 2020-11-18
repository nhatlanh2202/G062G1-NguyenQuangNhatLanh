package com.codegym.controller;


import com.codegym.entity.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"", "/product"})
@SessionAttributes(value = "productList")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("productList")
    public List<Product> productList(){
        return new ArrayList<>();
    }

    @GetMapping
    public String index(Model model, RedirectAttributes redirectAttributes){
        List<Product> productList = productService.findAll();
        model.addAttribute("products",productList);
        redirectAttributes.addFlashAttribute("success","");
        return "index";
    }

    @GetMapping("/product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/product/save")
    public String save(Product product, RedirectAttributes redirect) {
        productService.save(product);
        redirect.addFlashAttribute("success", "Saved product successfully !");
        return "redirect:/product";
    }

    @GetMapping("/product/{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }

    @GetMapping("/{id}/addProduct")
    public String addProduct(List<Product> productList, @PathVariable Integer id, Model model) {
        Product product = productService.findById(id);
        product.setQuantity(1);
        productList.add(product);
        return "redirect:/productList";
    }

    @GetMapping("/{id}/delete-product-list")
    public String deleteProductList(List<Product> productList, @PathVariable Integer id, Model model) {
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                productList.remove(product);
                break;
            }
        }
        return "redirect:/productList";
    }

    @GetMapping("/deleteAll")
    public String deleteAll(List<Product> productList) {
        productList.clear();
        return "redirect:/productList";
    }

    @GetMapping("/productList")
    public String listProduct(Model model) {
        Integer[] quantityProducts = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        model.addAttribute("quantityProducts", quantityProducts);
        return "product-list";
    }
}
