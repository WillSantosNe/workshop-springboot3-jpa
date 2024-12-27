package com.estudoswill.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.estudoswill.course.entities.User;
import com.estudoswill.course.repositories.UserRepository;

// Os services funcionam como uma ponte entre os controlares e o Repository

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		
		// Retorna objeto do tipo user de dentro do Optional
		return obj.get();
	}
}
