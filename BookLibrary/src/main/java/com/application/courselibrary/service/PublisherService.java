package com.application.courselibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.courselibrary.entity.Author;
import com.application.courselibrary.entity.Publisher;
import com.application.courselibrary.repository.PublisherRepository;
@Service
public class PublisherService {
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	public List <Publisher> findAllPublishers(){
		return publisherRepository.findAll();
	}
	
	public Publisher findPublisherById(Long id) {
		Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher not found"));
		return publisher;
	}
	public void createPublisher(Publisher publisher) {
		publisherRepository.save(publisher);
	}
	public void updatePublisher(Publisher publisher) {
		publisherRepository.save(publisher);
	}
	public void deletePublisher(Long id) {
		Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher not found"));
		publisherRepository.deleteById(publisher.getId());
		
		
	}
	
	
	
	
	
	
	
	
}
