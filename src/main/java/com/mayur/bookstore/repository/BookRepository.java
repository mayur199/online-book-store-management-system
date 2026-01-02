package com.mayur.bookstore.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mayur.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findByTitleContainingIgnoreCase(String title);
	@Override
	Page<Book> findAll(Pageable pageable);
	List<Book> findByAuthorContainingIgnoreCase(String author);

}
