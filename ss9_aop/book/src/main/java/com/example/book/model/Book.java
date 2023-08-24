package com.example.book.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    private int quantity;
    @OneToMany(mappedBy = "book")
    private Set<BookBorrow> bookBorrowSet;

    public Set<BookBorrow> getBookBorrowSet() {
        return bookBorrowSet;
    }

    public void setBookBorrowSet(Set<BookBorrow> bookBorrowSet) {
        this.bookBorrowSet = bookBorrowSet;
    }

    public Book() {
    }

    public Book(int id, String name, String author, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
    }

    public Book(int id, String name, String author, int quantity, Set<BookBorrow> bookBorrowSet) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.bookBorrowSet = bookBorrowSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
