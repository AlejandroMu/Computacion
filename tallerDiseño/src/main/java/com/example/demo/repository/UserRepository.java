package com.example.demo.repository;
import com.example.demo.model.*;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer>{
    User findByLogin(String p);
}