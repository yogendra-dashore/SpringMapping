package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.StudentsEntity;
import com.repository.CourseRepository;
import com.repository.StudentsRepository;

@RestController
public class StudentsController {

	@Autowired
	StudentsRepository studentsRepository;
	
//	@Autowired
//	CourseRepository courseRepository;
	
	@PostMapping("/studentadd")
	public StudentsEntity addStudents(@RequestBody StudentsEntity student) {
		//courseRepository.save(student.getCourseEntity());
		studentsRepository.save(student);
		return student;
	}
}
