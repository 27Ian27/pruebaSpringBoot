package com.proyecto.libreria.contoller;

import com.proyecto.libreria.model.Book;

import java.util.List;

public interface IService {

    public List<Book> listBook();

    public void save(Book book);

    public void delete(Book book);

    public Book findBook(Book book);
}
