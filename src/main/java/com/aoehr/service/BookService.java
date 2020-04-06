package com.aoehr.service;

import com.aoehr.entity.Book;

import java.util.List;

public interface BookService {

    Book saveBook(Book book);

    List<Book> listAllBook();
    Book getBookById(Long id);

    void deleteBook(Long id);
    Book updateBook(Book book);
}
