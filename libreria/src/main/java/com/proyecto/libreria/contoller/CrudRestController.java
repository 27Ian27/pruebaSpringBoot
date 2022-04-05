package com.proyecto.libreria.contoller;

import com.proyecto.libreria.model.Book;
import com.proyecto.libreria.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class CrudRestController {
    private final BookRepository bookRepository;

    public CrudRestController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @GetMapping("/")
    List<Book> all(){
        return bookRepository.findAll();
    }

    @PostMapping("/{id}")
    Book newBook(@RequestBody Book newBook){
        return bookRepository.save(newBook);
    }
    @GetMapping("/{id}")
    Book getOne(@PathVariable Long id){
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @PutMapping("/{id}")
    Book replaceBook(@RequestBody Book newBook, @PathVariable Long id){
        return  bookRepository.findById(id).map(book -> {
            book.setName(newBook.getName());
            if(newBook.getPages() != null){
                book.setPages(newBook.getPages());
            }
            return bookRepository.save(book);
        }).orElseThrow(() -> new BookNotFoundException(id));
    }
    @DeleteMapping("/{name_book}")
    void deleteBook(@PathVariable Long name){
    }
}
