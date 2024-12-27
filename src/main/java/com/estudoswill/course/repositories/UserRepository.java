package com.estudoswill.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudoswill.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
