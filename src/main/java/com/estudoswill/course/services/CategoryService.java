package com.estudoswill.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudoswill.course.entities.Category;
import com.estudoswill.course.repositories.CategoryRepository;

// Os services funcionam como uma ponte entre os controlares e o Repository

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository CategoryRepository;
	
	public List<Category> findAll(){
		return CategoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = CategoryRepository.findById(id);
		
		// Retorna objeto do tipo Category de dentro do Optional
		return obj.get();
	}
}
