package com.codegym.service;

import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    void save(Category category);

    Category findById(Long id);

    void update(Long id, Category category);

    void remove(Long id);

    Page<Category> findAll(Pageable pageable);

    Iterable<Category> findAll();
}
