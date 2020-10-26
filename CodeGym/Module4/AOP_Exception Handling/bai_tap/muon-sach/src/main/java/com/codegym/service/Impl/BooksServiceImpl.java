package com.codegym.service.Impl;

import com.codegym.entity.BookLoanNumber;
import com.codegym.entity.Books;
import com.codegym.repository.BookLoanNumberRepository;
import com.codegym.repository.BooksRepository;
import com.codegym.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private BookLoanNumberRepository bookLoanNumberRepository;

    @Override
    public List<Books> findAll() {
        return this.booksRepository.findAll();
    }

    @Override
    public Books findById(Integer id) {
        return this.booksRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Books books) {
        this.booksRepository.save(books);
    }

    @Override
    public void borrow(Integer id) throws Exception {
        Books book = findById(id);
        if (book.getQuantity() == 0) {
            throw new Exception("Hết sách rồi mà cũng bấm mượn được hay thiệt ?!");
        } else {
            book.setQuantity(book.getQuantity() - 1);
            BookLoanNumber bookLoanNumber = new BookLoanNumber();
            bookLoanNumber.setId((int) (Math.random() * 100));
            bookLoanNumber.setLoanNumber((int) ((Math.random() * 99999) + 10000));
            this.bookLoanNumberRepository.save(bookLoanNumber);
        }
    }

    @Override
    public String giveBack(Integer loanNumber, Integer id) {
        List<BookLoanNumber> bookLoanNumberList = this.bookLoanNumberRepository.findAll();
        boolean check = false;
        for (BookLoanNumber bookLoanNumber : bookLoanNumberList) {
            if (bookLoanNumber.getLoanNumber().equals(loanNumber)) {
                check = true;
                Books book = findById(id);
                book.setQuantity(book.getQuantity() + 1);
                this.bookLoanNumberRepository.delete(bookLoanNumber);
                break;
            }
        }
        if (check) {
            return "Give Back Complete !";
        } else {
            return "Book Loan Number is not exist !";
        }
    }
}
