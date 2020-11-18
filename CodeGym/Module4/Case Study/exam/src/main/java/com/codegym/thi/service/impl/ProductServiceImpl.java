package com.codegym.thi.service.impl;

import com.codegym.thi.entity.Product;
import com.codegym.thi.repository.ProductRepository;
import com.codegym.thi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findAllByProductNameContaining(String name, Pageable pageable) {
        return this.productRepository.findAllByProductNameContaining(name, pageable);
    }

    @Override
    public Page<Product> findAllByTypeProduct_NameType(String name, Pageable pageable) {
        return this.productRepository.findAllByTypeProduct_NameType(name, pageable);
    }

    @Override
    public Page<Product> findAllByStartPriceContaining(String name, Pageable pageable) {
        return this.productRepository.findAllByStartPriceContaining(name, pageable);
    }

    @Override
    public Page<Product> findAllByTypeProduct_NameTypeAndProductName(String name, String name1, Pageable pageable) {
        return this.productRepository.findAllByTypeProduct_NameTypeAndProductName(name, name1, pageable);
    }

    @Override
    public Page<Product> findAllByTypeProduct_NameTypeAndStartPrice(String name, String name1, Pageable pageable) {
        return this.productRepository.findAllByTypeProduct_NameTypeAndStartPrice(name, name1, pageable);
    }

    @Override
    public Page<Product> findAllByTypeProduct_NameTypeAndProductNameAndStartPrice(String typeProduct, String nameProduct, String startPrice, Pageable pageable) {
        return this.productRepository.findAllByTypeProduct_NameTypeAndProductNameAndStartPrice(typeProduct,nameProduct,startPrice,pageable);
    }


}
