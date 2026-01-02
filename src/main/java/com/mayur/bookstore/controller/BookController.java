package com.mayur.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mayur.bookstore.dto.BookDTO;
import com.mayur.bookstore.exception.BookNotFoundException;
import com.mayur.bookstore.model.Book;
import com.mayur.bookstore.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

	@Autowired
	private BookService service;

	@GetMapping
	public List<Book> getAllBooks() {
		return service.getAllBooks();
	}

	@PostMapping
	public Book addBook(@Valid @RequestBody BookDTO bookDTO) {
		Book book = new Book();
		book.setTitle(bookDTO.getTitle());
		book.setAuthor(bookDTO.getAuthor());
		book.setPrice(bookDTO.getPrice());
		book.setStock(bookDTO.getStock());
		return service.saveBook(book);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		Book book = service.getAllBooks().stream().filter(b -> b.getId().equals(id)).findFirst()
				.orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));

		service.deleteBook(id);
	}

	// Search by title
	@GetMapping("/search")
	public List<Book> searchBooks(@RequestParam String title) {
		return service.searchByTitle(title);
	}

	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO bookDTO) {
		Book book = service.getAllBooks().stream().filter(b -> b.getId().equals(id)).findFirst()
				.orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));

		book.setTitle(bookDTO.getTitle());
		book.setAuthor(bookDTO.getAuthor());
		book.setPrice(bookDTO.getPrice());
		book.setStock(bookDTO.getStock());

		return service.saveBook(book);
	}

	@GetMapping("/paged")
	public Page<Book> getBooksPaged(@RequestParam int page, @RequestParam int size,
			@RequestParam(defaultValue = "title") String sortBy) {
		return service.getBooksPaged(page, size, sortBy);
	}

	@GetMapping("/search/author")
	public List<Book> searchByAuthor(@RequestParam String author) {
		return service.searchByAuthor(author);
	}

	@PostMapping("/buy/{id}")
	public Book buyBook(@PathVariable Long id, @RequestParam int quantity) {
		Book book = service.getAllBooks().stream().filter(b -> b.getId().equals(id)).findFirst()
				.orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));

		if (book.getStock() < quantity) {
			throw new RuntimeException("Not enough stock available");
		}

		book.setStock(book.getStock() - quantity);
		return service.saveBook(book);
	}

}
