package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.model.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
    Optional<User> findByUsername(String username);
}