package com.example.blog.service;

import com.example.blog.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IAuthorService {
    List<Author> findAuthor();
}
