package com.codegym.repository;

import com.codegym.entity.BookLoanNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLoanNumberRepository extends JpaRepository<BookLoanNumber, Integer> {
}
