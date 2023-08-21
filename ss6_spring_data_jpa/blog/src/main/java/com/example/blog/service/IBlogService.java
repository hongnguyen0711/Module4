package com.example.blog.service;

import com.example.blog.model.Author;
import com.example.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void addBlog(Blog blog);


    void deleteBlog(int id);

    Blog findById(int id);

    void update(Blog blog);
}
