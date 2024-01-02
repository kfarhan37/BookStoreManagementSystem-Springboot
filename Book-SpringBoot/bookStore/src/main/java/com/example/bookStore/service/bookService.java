package com.example.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookStore.entity.Book;
import com.example.bookStore.repository.bookRepository;

@Service
public class bookService {

	@Autowired
	private bookRepository bookrepo;

	public void save(Book b) {
		bookrepo.save(b);
	}

	public List<Book> getAllBooks() {
		return bookrepo.findAll();
	}

	public Book getBookById(int id) {
		return bookrepo.findById(id).get();
	}

	public void deleteBookById(int id) {
		bookrepo.deleteById(id);
	}
}