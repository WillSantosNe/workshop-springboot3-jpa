package com.estudoswill.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudoswill.course.entities.Category;
import com.estudoswill.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	
	//Colocando dependencia para o Service
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = categoryService.findAll();			
		return ResponseEntity.ok().body(list);
	}
	
	// Indica que a requisição aceita um ID dentro da URL
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		
		// Faz uso de @PathVariable para indicar que o ID está vindo da URL
		Category obj = categoryService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
