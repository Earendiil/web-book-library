package com.application.courselibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.courselibrary.entity.Author;
import com.application.courselibrary.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public List <Author> findAllAuthors(){
		return authorRepository.findAll();
	}
	
	public Author findAuthorById(Long id) {
	Author author =	authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
		return author;
	}
	
	public void addAuthor(Author author) {
		authorRepository.save(author);
	}
	public void deleteAuthor(Long id) {
		Author author =	authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
		authorRepository.deleteById(author.getId());
	}
	
	public void updateAuthor(Long id, Author author) {
		Author authortoUpdate =	authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
		authortoUpdate.setBooks(author.getBooks());
		authortoUpdate.setDescription(author.getDescription());
		authortoUpdate.setName(author.getName());
		authorRepository.save(authortoUpdate);
	}

}
