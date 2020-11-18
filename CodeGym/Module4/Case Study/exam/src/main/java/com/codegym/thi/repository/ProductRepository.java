package com.codegym.thi.repository;

import com.codegym.thi.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllByProductNameContaining(String name, Pageable pageable);

    Page<Product> findAllByTypeProduct_NameType(String name, Pageable pageable);

    Page<Product> findAllByStartPriceContaining(String name, Pageable pageable);

    Page<Product> findAllByTypeProduct_NameTypeAndProductName(String name, String name1, Pageable pageable);

    Page<Product> findAllByTypeProduct_NameTypeAndStartPrice(String name, String name1, Pageable pageable);

    Page<Product> findAllByTypeProduct_NameTypeAndProductNameAndStartPrice(String typeProduct, String nameProduct, String startPrice, Pageable pageable);
}
