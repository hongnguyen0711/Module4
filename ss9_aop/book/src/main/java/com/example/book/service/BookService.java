package com.example.book.service;

import com.example.book.model.Book;
import com.example.book.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository repository;

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Book> searchByName(Pageable pageable, String keyword) {
        return repository.findBookByNameContaining(pageable, keyword);
    }
}
