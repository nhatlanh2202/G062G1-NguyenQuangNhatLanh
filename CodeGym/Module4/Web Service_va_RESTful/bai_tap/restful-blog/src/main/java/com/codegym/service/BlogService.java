package com.codegym.service;

import com.codegym.entity.Blog;

import java.util.List;

public interface BlogService {

    List<Blog> findAll();

    Blog findById(String id);

    void save(Blog blog);

    void edit(Blog blog);

    void delete(String id);

}
