package com.application.courselibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.courselibrary.entity.Book;

public interface BookRepository extends JpaRepository <Book, Long> {

}
