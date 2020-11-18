package com.codegym.thi.controller;


import com.codegym.thi.entity.Product;
import com.codegym.thi.service.ProductService;
import com.codegym.thi.service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private TypeProductService typeProductService;

    @GetMapping({"","/products"})
    public ModelAndView listProduct(@PageableDefault(value = 3) Pageable pageable,
                                    @RequestParam(value = "searchNameProduct", defaultValue = "") String searchNameProduct,
                                    @RequestParam(value = "searchStartPrice", defaultValue = "") String searchStartPrice,
                                    @RequestParam(value = "searchTypeProduct", defaultValue = "all") String searchTypeProduct){
        Page<Product> products = null;
        if (searchNameProduct.equals("") && searchStartPrice.equals("") && searchTypeProduct.equals("all")){
            products = productService.findAll(pageable);
        }else if (searchTypeProduct.equals("all") && searchStartPrice.equals("")){
            products = productService.findAllByProductNameContaining(searchNameProduct, pageable);
        }else if (searchTypeProduct.equals("all") && searchNameProduct.equals("")){
            products = productService.findAllByStartPriceContaining(searchStartPrice, pageable);
        }else if (searchNameProduct.equals("") && searchStartPrice.equals("") && !searchTypeProduct.equals("all")){
            products = productService.findAllByTypeProduct_NameType(searchTypeProduct, pageable);
        }else if (searchNameProduct.equals("") && !searchStartPrice.equals("") && !searchTypeProduct.equals("all")){
            products = productService.findAllByTypeProduct_NameTypeAndStartPrice(searchStartPrice, searchTypeProduct, pageable);
        }else if (!searchNameProduct.equals("") && searchStartPrice.equals("") && !searchTypeProduct.equals("all")){
            products = productService.findAllByTypeProduct_NameTypeAndProductName(searchNameProduct, searchTypeProduct, pageable);
        }else {
            products = productService.findAllByTypeProduct_NameTypeAndProductNameAndStartPrice(searchNameProduct, searchStartPrice, searchTypeProduct, pageable);
        }
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("products", products);
        modelAndView.addObject("typeProducts", typeProductService.findAll());
        modelAndView.addObject("newProduct", new Product());
        modelAndView.addObject("searchNameProduct", searchNameProduct);
        modelAndView.addObject("searchStartPrice",searchStartPrice);
        modelAndView.addObject("searchTypeProduct", searchTypeProduct);
        return modelAndView;
    }


    @PostMapping("/create-product")
    public String createProduct(@Validated @ModelAttribute("product") Product product, BindingResult bindingResult,
                                Model model, @PageableDefault(value = 3) Pageable pageable) {
        if (bindingResult.hasErrors()) {
            Page<Product> products = productService.findAll(pageable);
            model.addAttribute("products", products);
            model.addAttribute("typeProducts", typeProductService.findAll());
            return "product/list";
        }
        productService.save(product);
        return "redirect:/products";
    }

    @PostMapping("/delete-product")
    public String deleteProduct(@RequestParam Long id) {
        productService.remove(id);
        return "redirect:/products";
    }
}
