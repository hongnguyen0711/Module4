package com.example.book.repository;

import com.example.book.model.BookBorrow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookBorrowRepository extends JpaRepository<BookBorrow, Integer> {
     Page<BookBorrow> searchBookBorrowByCodeContaining(Pageable pageable, String keyword);
}
