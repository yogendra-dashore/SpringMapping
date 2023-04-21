package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.StudentsEntity;

@Repository
public interface StudentsRepository extends CrudRepository<StudentsEntity, Integer>{

	List<StudentsEntity> findAll();
}
