package com.estudoswill.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudoswill.course.entities.User;
import com.estudoswill.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	
	//Colocando dependencia para o Service
	@Autowired
	private UserService userService;
	
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = userService.findAll();			
		return ResponseEntity.ok().body(list);
	}
	
	// Indica que a requisição aceita um ID dentro da URL
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		
		// Faz uso de @PathVariable para indicar que o ID está vindo da URL
		User obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
