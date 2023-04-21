package com.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.CourseEntity;

@Repository
public interface CourseRepository extends CrudRepository<CourseEntity, Integer>{

	//void save(Set<CourseEntity> courseEntity);

}
