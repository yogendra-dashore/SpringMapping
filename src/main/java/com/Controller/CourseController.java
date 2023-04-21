package com.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CourseEntity;
import com.repository.CourseRepository;

@RestController
public class CourseController {

	@Autowired
	CourseRepository courseRepository;
	
	
	@PostMapping("/courseInsert")
	public CourseEntity addCours(@RequestBody CourseEntity course) {
		courseRepository.save(course);
		return course;
	}
	
	@GetMapping("/getAllcourse")
	public List<CourseEntity> getCourse() {
		return courseRepository.findAll();
		
	}
	
	@GetMapping("/cours/{Id}")
	public CourseEntity getCourseById(@PathVariable("id") Integer Id) {
		Optional<CourseEntity> course = courseRepository.findById(Id);
		if(course.isEmpty()) {
			return null;
			
		}else {
			return course.get();
		}
	}
	@DeleteMapping("/deletecourse/{Id}")
	public CourseEntity deleteById(@PathVariable("Id") Integer Id) {
		CourseEntity course = courseRepository.findById(Id).get();
		courseRepository.delete(course);
		return course;
	}
	
	@PutMapping("/courseupdt")
	public CourseEntity updateCourse( @RequestBody CourseEntity course) {
		courseRepository.save(course);
		return course;
	}
}
