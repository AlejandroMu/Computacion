package com.example.demo.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UrgencyAtention;
@Repository
public interface AtentionRepository extends CrudRepository<UrgencyAtention,Integer> {

}
