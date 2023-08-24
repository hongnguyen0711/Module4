package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    IBookService service;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0", required = false) int page,
                           @RequestParam(defaultValue = "", required = false) String keyword, Model model) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<Book> list = service.searchByName(pageable,keyword);
        model.addAttribute("books", list);
        return "list";
    }
}
