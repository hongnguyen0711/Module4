package com.example.book.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "customer")
    private Set<BookBorrow> bookBorrowSet;


    public Set<BookBorrow> getBookBorrowSet() {
        return bookBorrowSet;
    }

    public void setBookBorrowSet(Set<BookBorrow> bookBorrowSet) {
        this.bookBorrowSet = bookBorrowSet;
    }

    public Customer() {
    }

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
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
}
