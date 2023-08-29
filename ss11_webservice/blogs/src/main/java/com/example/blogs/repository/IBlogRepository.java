package com.example.blogs.repository;

import com.example.blogs.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findBlogByTitleContaining(Pageable pageable, String keyword);
    @Query(value = "select * from blog where title like :name", nativeQuery = true)
    List<Blog> findBlogByTitle(@Param("name") String name);

    @Query(value = "select * from blog", nativeQuery = true)
    List<Blog> getAll();

    @Query(value = "select * from Blog where id = :id", nativeQuery = true)
    Blog getBlogId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "delete from Blog where id = :id", nativeQuery = true)
    void removeById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "insert into Blog(title, post, comment, author_id) value(:title, :post, :comment, :author)", nativeQuery = true)
    void addNewBlog(@Param("title") String title, @Param("post") String post, @Param("comment") String comment, @Param("author") int author);

    @Modifying
    @Transactional
    @Query(value = "update Blog set title = :title, post = :post, comment = :comment, author_id = :author where id = :id", nativeQuery = true)
    void updateBlog(@Param("id") int id, @Param("title") String title, @Param("post") String post, @Param("comment") String comment, @Param("author") int author);
}
