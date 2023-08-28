package com.example.blogs.service;

import com.example.blogs.model.Blog;
import com.example.blogs.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
@Autowired
private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void addBlog(Blog blog) {
        blogRepository.addNewBlog(blog.getTitle(),blog.getPost(), blog.getComment(), blog.getAuthor().getId());
    }

    @Override
    public void deleteBlog(int id) {
        blogRepository.removeById(id);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.getBlogId(id);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.updateBlog(blog.getId(),blog.getTitle(),blog.getPost(), blog.getComment(), blog.getAuthor().getId());
    }

    @Override
    public Page<Blog> searchByName(Pageable pageable,String keyword) {
        return blogRepository.findBlogByTitleContaining(pageable,keyword);
    }

}
