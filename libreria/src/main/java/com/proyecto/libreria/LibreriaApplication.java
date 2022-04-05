package com.proyecto.libreria;

import com.proyecto.libreria.model.Book;
import com.proyecto.libreria.repository.BookRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class LibreriaApplication implements CommandLineRunner {

	private final Log logger = LogFactory.getLog(this.getClass());
	private BookRepository bookRepository;

	@Autowired
	private JdbcTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(LibreriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		saveBookInDB();
		getBook();
	}

	private void getBook(){
		List<Book> books = bookRepository.findAll();
		books.forEach(book -> logger.info(book.toString()));
	}

	private void saveBookInDB(){
		Book book1 = new Book("La ileada", 3232);
		Book book2 = new Book("La odisea", 53);
		Book book3 = new Book("Book1", 4355);
		Book book4 = new Book("Book2", 344);
		Book book5 = new Book("Book3", 435);
		Book book6 = new Book("Book4", 332);
		Book book7 = new Book("Book5", 324);
		List<Book> list = Arrays.asList(book1, book2, book3, book4, book5, book6, book7);
		list.stream().forEach(bookRepository::save);
	}
}
