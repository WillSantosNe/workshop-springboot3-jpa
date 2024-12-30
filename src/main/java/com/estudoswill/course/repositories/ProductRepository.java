package com.estudoswill.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudoswill.course.entities.Product;

// Interface responsável pelas operações do banco de dados

// Não é necessária uma anotação @Repository por conta de herdar do JpaRepository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
