package com.example.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookStore.entity.myBook;
import com.example.bookStore.repository.myBookRepository;

@Service
public class myBookService {

	@Autowired
	private myBookRepository mybookrepo;

	public void saveMyBooks(myBook mb) {
		mybookrepo.save(mb);
	}

	public List<myBook> getAllMyBooks() {
		return mybookrepo.findAll();
	}

	public void deleteById(int id) {
		mybookrepo.deleteById(id);
	}
}