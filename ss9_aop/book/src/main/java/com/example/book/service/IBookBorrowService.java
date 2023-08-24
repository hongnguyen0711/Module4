package com.example.book.service;

import com.example.book.model.BookBorrow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookBorrowService {
    Page<BookBorrow> searchByCode(Pageable pageable, String keyword);
}
