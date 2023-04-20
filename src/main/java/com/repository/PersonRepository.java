package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.PersonEntity;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {

	List<PersonEntity> findAll();
	
	
}
