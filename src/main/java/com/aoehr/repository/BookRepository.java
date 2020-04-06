package com.aoehr.repository;

import com.aoehr.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findBookId(Long id);
}
