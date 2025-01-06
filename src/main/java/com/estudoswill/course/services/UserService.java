package com.estudoswill.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudoswill.course.entities.User;
import com.estudoswill.course.repositories.UserRepository;
import com.estudoswill.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

// Os services funcionam como uma ponte entre os controlares e o Repository

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);

		// Retorna objeto do tipo user de dentro do Optional
		// Tenta fazer o get, mas se der problema ele lança oa exceção
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	// Função para salvar no banco de dados e retornar o Usuário salvo
	public User insert(User obj) {
		return userRepository.save(obj);
	}

	public void delete(Long id) {
		try {
			if (!userRepository.existsById(id)) {
				throw new ResourceNotFoundException(id);
			}
			userRepository.deleteById(id);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public User update(Long id, User obj) {
		try {
			User entity = userRepository.getReferenceById(id);
			updateData(entity, obj);
			return userRepository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
