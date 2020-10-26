package com.codegym.service.Impl;

import com.codegym.entity.BookLoanNumber;
import com.codegym.repository.BookLoanNumberRepository;
import com.codegym.service.BookLoanNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookLoanNumberServiceImpl implements BookLoanNumberService {
    @Autowired
    private BookLoanNumberRepository bookLoanNumberRepository;

    @Override
    public List<BookLoanNumber> findAll() {
        return this.bookLoanNumberRepository.findAll();
    }

    @Override
    public void save(BookLoanNumber bookLoanNumber) {
        this.bookLoanNumberRepository.save(bookLoanNumber);
    }
}