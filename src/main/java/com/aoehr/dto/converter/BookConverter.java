package com.aoehr.dto.converter;

import com.aoehr.dto.BookDto;
import com.aoehr.entity.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookConverter {

    public static List<BookDto> bookEntityToBookDto(List<Book> books) {
        return books != null ? books.stream()
                .map(b -> new BookDto(b.getId(), b.getName()))
                .collect(Collectors.toList()) : null;
    }

    public static BookDto bookEntityToBookDto(Book book) {
        return book != null ? new BookDto(book.getId(), book.getName()) : null;
    }

    public static Book bookDtoToBookEntity(BookDto bookDto) {
        return bookDto != null ? new Book(bookDto.getId(), bookDto.getName()) : null;
    }

    private BookConverter() {
    }
}
