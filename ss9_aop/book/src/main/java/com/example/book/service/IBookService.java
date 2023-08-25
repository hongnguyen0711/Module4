package com.example.book.service;

import com.example.book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {

    List<Book> findAll();

    Page<Book> searchByName(Pageable pageable, String keyword);

    Book findById(int id);

    void borrow(Book book);
}
