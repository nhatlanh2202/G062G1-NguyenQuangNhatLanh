package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public Product findById(Integer product_id) {
        return this.productRepository.findById(product_id);
    }

    @Override
    public void update(Product product) {
        this.productRepository.update(product);

    }

    @Override
    public void remove(Integer product_id) {
        this.productRepository.remove(product_id);
    }
}
