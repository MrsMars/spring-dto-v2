package com.aoehr.dto.mapper;

import com.aoehr.dto.BookDto;
import com.aoehr.entity.Book;
import com.aoehr.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.aoehr.dto.converter.BookConverter.bookDtoToBookEntity;
import static com.aoehr.dto.converter.BookConverter.bookEntityToBookDto;

@Service
public class BookMapper {

    @Autowired
    private BookService bookService;

    public Book saveBook(BookDto bookDto) {
        return bookService.saveBook(bookDtoToBookEntity(bookDto));
    }

    public List<BookDto> viewBook() {
        List<Book> bookList = bookService.listAllBook();
        return bookEntityToBookDto(bookList);
    }

    public BookDto getById(Long id) {
        Book book = bookService.getBookById(id);
        return bookEntityToBookDto(book);
    }

    public void deleteBook(Long id) {
        bookService.deleteBook(id);
    }
}
