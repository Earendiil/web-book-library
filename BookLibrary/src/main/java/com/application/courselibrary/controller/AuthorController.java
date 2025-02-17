package com.application.courselibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.application.courselibrary.entity.Author;
import com.application.courselibrary.service.AuthorService;

@Controller
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/authors")
	public String findAllAuthors(Model model) {
		model.addAttribute("authors", authorService.findAllAuthors());
		return "authors";
	}
	 @GetMapping("/remove-author/{id}")
	 public String deleteAuthor (@PathVariable Long id, Model model) {
		 authorService.deleteAuthor(id);
		 model.addAttribute("authors", authorService.findAllAuthors());
		 return "authors";
	 }
	 
	 @GetMapping("/update-author/{id}")
	 public String updateAuthor(@PathVariable Long id, Model model) {
		model.addAttribute("author", authorService.findAuthorById(id));
		 return "update-author";
	 }
	 @PostMapping("/update-author/{id}")
	 public String saveAuthor(@PathVariable Long id, Author author, Model model,BindingResult result) {
		 if (result.hasErrors()) {
			return "update-author";
		}
		 authorService.updateAuthor(id, author);
		 model.addAttribute("authors", authorService.findAllAuthors());
		 return "redirect:/authors";
	 }
	 @GetMapping("/add-author")
	 public String showSaveAuthor(Author author) {
		 return "add-author";
	 }
	 
	 @PostMapping("/save-author")
	 public String saveAuthor(Model model,Author author, BindingResult result) {
		 if (result.hasErrors()) {
			return "add-author";
		}
		 authorService.addAuthor(author);
		 model.addAttribute("authors", authorService.findAllAuthors());
		 return "redirect:/authors";
	 }
	 
	
	
	
}
