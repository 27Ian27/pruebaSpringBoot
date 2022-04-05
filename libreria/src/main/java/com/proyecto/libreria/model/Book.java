package com.proyecto.libreria.model;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.math.BigDecimal;


@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book", nullable = false, unique = true)
    private Long id;
    @Column(name = "name_book", length = 50, nullable = false)
    private String name;
    @Column(name = "pages_book", nullable = true)
    private Integer pages;

    public Book() {
    }

    public Book(String name, Integer pages) {
        this.name = name;
        this.pages = pages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pages=" + pages +
                '}';
    }
}
