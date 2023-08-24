package com.example.book.service;

import com.example.book.model.BookBorrow;
import com.example.book.repository.IBookBorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookBorrowService implements IBookBorrowService {
    @Autowired
    IBookBorrowRepository repository;

    @Override
    public Page<BookBorrow> searchByCode(Pageable pageable, String keyword) {
        return repository.searchBookBorrowByCodeContaining(pageable, keyword);
    }
}
