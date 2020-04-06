package com.aoehr.controller;

import com.aoehr.dto.BookDto;
import com.aoehr.dto.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @PostMapping("/saveBook")
    public ResponseEntity<String> saveBook(@Valid @RequestBody BookDto bookDto) {
        return bookMapper.saveBook(bookDto) != null ?
                new ResponseEntity<>("successfully", HttpStatus.OK) :
                new ResponseEntity<>("save failed", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/listBook")
    public List<BookDto> getBook() {
        return bookMapper.viewBook();
    }

    @GetMapping("/getbyid/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookMapper.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        if (bookMapper.getById(id) != null) {
            bookMapper.deleteBook(id);
            return new ResponseEntity<>("successfully delete", HttpStatus.OK);

        }
        return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
    }
}
