package com.application.courselibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.courselibrary.entity.Category;

public interface CategoryRepository extends JpaRepository <Category, Long>{

	
	
}
