package com.codegym.service;

import com.codegym.model.Category;

public interface CategoryService {
    Iterable<Category> findAll();

    void save(Category category);

    Category findById(int id);

    void update(Category category);

    void remove(Category category);
}
