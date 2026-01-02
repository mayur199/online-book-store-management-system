package com.mayur.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mayur.bookstore.model.Book;
import com.mayur.bookstore.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repo;

	public List<Book> getAllBooks() {
		return repo.findAll();
	}

	public Book saveBook(Book book) {
		return repo.save(book);
	}

	public void deleteBook(Long id) {
		repo.deleteById(id);
	}

	public List<Book> searchByTitle(String keyword) {
		return repo.findByTitleContainingIgnoreCase(keyword);
	}

	public Page<Book> getBooksPaged(int page, int size, String sortBy) {
		return repo.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
	}

	public List<Book> searchByAuthor(String author) {
		return repo.findByAuthorContainingIgnoreCase(author);
	}
}
