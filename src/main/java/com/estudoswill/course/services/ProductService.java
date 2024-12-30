package com.estudoswill.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.estudoswill.course.entities.Product;
import com.estudoswill.course.repositories.ProductRepository;

// Os services funcionam como uma ponte entre os controlares e o Repository

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = productRepository.findById(id);
		
		// Retorna objeto do tipo Product de dentro do Optional
		return obj.get();
	}
}
