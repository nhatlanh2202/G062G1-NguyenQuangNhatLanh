package com.codegym.service;

import com.codegym.entity.BookLoanNumber;

import java.util.List;

public interface BookLoanNumberService {
    List<BookLoanNumber> findAll();

    void save(BookLoanNumber bookLoanNumber);
}
