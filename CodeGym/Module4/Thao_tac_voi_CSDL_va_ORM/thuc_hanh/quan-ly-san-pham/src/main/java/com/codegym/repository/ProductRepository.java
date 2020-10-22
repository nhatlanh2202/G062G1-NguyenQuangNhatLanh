package com.codegym.repository;


import com.codegym.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

    Product findById(Integer product_id);

    void save(Product product);

    void update(Product product);

    void remove(Integer product_id);
}
