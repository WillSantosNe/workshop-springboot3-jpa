package com.estudoswill.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.estudoswill.course.entities.Order;
import com.estudoswill.course.repositories.OrderRepository;

// Os services funcionam como uma ponte entre os controlares e o Repository

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository OrderRepository;
	
	public List<Order> findAll(){
		return OrderRepository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = OrderRepository.findById(id);
		
		// Retorna objeto do tipo Order de dentro do Optional
		return obj.get();
	}
}
