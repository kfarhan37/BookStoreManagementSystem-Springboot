package com.example.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookStore.entity.Book;
import com.example.bookStore.entity.myBook;
import com.example.bookStore.service.bookService;
import com.example.bookStore.service.myBookService;

@Controller
public class bookController {

	@Autowired
	private bookService bookserv;

	@Autowired
	private myBookService mybookserv;

	@GetMapping("/")
	public String home() {
		return "homepage";
	}

	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookregisterpage";
	}

	@GetMapping("/available_books")
	public ModelAndView getAllBooks() {
		List<Book> ls = bookserv.getAllBooks();
		ModelAndView mv = new ModelAndView();
		mv.addObject("book", ls);
		mv.setViewName("bookspage");
		return mv;
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		bookserv.save(b);
		return "redirect:/available_books";
	}

	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<myBook> list = mybookserv.getAllMyBooks();
		model.addAttribute("book", list);
		return "mybookspage";
	}

	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = bookserv.getBookById(id);
		myBook mb = new myBook(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		mybookserv.saveMyBooks(mb);
		return "redirect:/my_books";
	}

	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book b = bookserv.getBookById(id);
		model.addAttribute("book", b);
		return "bookeditpage";
	}

	@RequestMapping("deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bookserv.deleteBookById(id);
		return "redirect:/available_books";
	}
}