package com.example.blog.controller;

import com.example.blog.model.Author;
import com.example.blog.model.Blog;
import com.example.blog.service.IAuthorService;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    IAuthorService authorService;

    @GetMapping("")
    public String showPage(@RequestParam(defaultValue = "0", required = false) int page,
                           @RequestParam(defaultValue = "", required = false) String keyword, Model model) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by("title").descending());
        Page<Blog> blogPage = blogService.searchByName(pageable, keyword);
        model.addAttribute("blogs", blogPage);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        List<Author> authorList = authorService.findAuthor();
        model.addAttribute("blog", new Blog());
        model.addAttribute("authors", authorList);
        return "create";
    }

    @PostMapping("/create")
    public String create(Blog blog, RedirectAttributes redirect) {
        blogService.addBlog(blog);
        redirect.addFlashAttribute("success", "save successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        blogService.deleteBlog(id);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "detail";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable int id, Model model) {
        List<Author> authorList = authorService.findAuthor();
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("authors", authorList);

        return "edit";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirect) {
        blogService.update(blog);
        redirect.addFlashAttribute("message", "Update successful!");
        return "redirect:/blog";
    }

}
