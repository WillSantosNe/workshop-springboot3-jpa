package com.estudoswill.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudoswill.course.entities.Order;
import com.estudoswill.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	
	//Colocando dependencia para o Service
	@Autowired
	private OrderService orderService;
	
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = orderService.findAll();			
		return ResponseEntity.ok().body(list);
	}
	
	// Indica que a requisição aceita um ID dentro da URL
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		
		// Faz uso de @PathVariable para indicar que o ID está vindo da URL
		Order obj = orderService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
