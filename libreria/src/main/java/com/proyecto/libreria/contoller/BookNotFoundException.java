package com.proyecto.libreria.contoller;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long id){
        super(("Could not find user" + id));
    }
}
