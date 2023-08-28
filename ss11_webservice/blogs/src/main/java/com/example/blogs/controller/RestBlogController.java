package com.example.blogs.controller;

import com.example.blogs.model.Author;
import com.example.blogs.model.Blog;
import com.example.blogs.service.IAuthorService;
import com.example.blogs.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/blog")
public class RestBlogController {
    @Autowired
    private IBlogService service;
    @Autowired
    IAuthorService authorService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getAll() {
        List<Blog> blogList = service.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable int id) {
        Blog blog = service.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/author")
    public ResponseEntity<List<Author>> getAllAuthor() {
        List<Author> authorList = authorService.findAuthor();
        if (authorList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }
}
