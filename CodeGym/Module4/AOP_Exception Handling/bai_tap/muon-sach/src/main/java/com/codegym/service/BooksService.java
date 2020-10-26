package com.codegym.service;

import com.codegym.entity.Books;

import java.util.List;

public interface BooksService {
    List<Books> findAll();

    Books findById(Integer id);

    void save(Books books);

    void borrow(Integer id) throws Exception;

    String giveBack(Integer loanNumber, Integer id);
}
