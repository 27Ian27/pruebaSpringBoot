package com.proyecto.libreria.repository;

import com.proyecto.libreria.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    @Query("SELECT u FROM Book u WHERE u.book_name=?1")
    Optional<Book> findById(String name);

    List<Book> findAll();
}
