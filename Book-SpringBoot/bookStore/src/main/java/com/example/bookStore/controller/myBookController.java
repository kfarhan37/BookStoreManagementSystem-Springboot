package com.example.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookStore.service.myBookService;

@Controller
public class myBookController {

	@Autowired
	private myBookService mybookserv;

	@RequestMapping("/deleteMyBooks/{id}")
	public String deleteMyBook(@PathVariable("id") int id) {

		mybookserv.deleteById(id);
		return "redirect:/my_books";
	}

}