package com.example.blog.service;

import com.example.blog.model.Author;
import com.example.blog.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {
    @Autowired
    IAuthorRepository authorRepository;
    @Override
    public List<Author> findAuthor() {
        return authorRepository.findAll();
    }
}
