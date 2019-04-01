package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findByName(String name);
	List<User> findByRol(String rol);
}
