package com.estudoswill.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudoswill.course.entities.Product;
import com.estudoswill.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource { 
	
	
	//Colocando dependencia para o Service
	@Autowired
	private ProductService productService;
	
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = productService.findAll();			
		return ResponseEntity.ok().body(list);
	}
	
	// Indica que a requisição aceita um ID dentro da URL
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		
		// Faz uso de @PathVariable para indicar que o ID está vindo da URL
		Product obj = productService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
