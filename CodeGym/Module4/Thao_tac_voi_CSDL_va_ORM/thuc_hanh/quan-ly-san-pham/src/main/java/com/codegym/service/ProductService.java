package com.codegym.service;



import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(Integer product_id);

    void update(Product product);

    void remove(Integer product_id);
}
