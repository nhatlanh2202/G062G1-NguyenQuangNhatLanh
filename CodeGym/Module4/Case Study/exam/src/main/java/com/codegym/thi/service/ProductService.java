package com.codegym.thi.service;

import com.codegym.thi.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    void save(Product product);

    void remove(Long id);

    List<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllByProductNameContaining(String name, Pageable pageable);

    Page<Product> findAllByTypeProduct_NameType(String name, Pageable pageable);

    Page<Product> findAllByStartPriceContaining(String name, Pageable pageable);

    Page<Product> findAllByTypeProduct_NameTypeAndProductName(String name, String name1, Pageable pageable);

    Page<Product> findAllByTypeProduct_NameTypeAndStartPrice(String name, String name1, Pageable pageable);

    Page<Product> findAllByTypeProduct_NameTypeAndProductNameAndStartPrice(String typeProduct, String nameProduct, String startPrice, Pageable pageable);
}
