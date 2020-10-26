package com.codegym.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookLoanNumber {
    @Id
    private Integer id;
    private Integer loanNumber;

    public BookLoanNumber() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(Integer loanNumber) {
        this.loanNumber = loanNumber;
    }
}
