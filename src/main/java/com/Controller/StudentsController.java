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
	
	@GetMapping("/Allstudent")
	public List<StudentsEntity> getStudents() {
		
		return studentsRepository.findAll();
	}
	
	@GetMapping("/AllStudentByid/{Id}")
	public StudentsEntity getStudentsById(@PathVariable("Id") Integer Id) {
		Optional<StudentsEntity> student = studentsRepository.findById(Id);
		if(student.isEmpty())
		{
			return null;
		}
		else {
			return student.get();
		}
	}
	
	@DeleteMapping("/deleteStudentById/{Id}")
	public StudentsEntity deleteById(@PathVariable("Id") Integer id) {
		StudentsEntity student = studentsRepository.findById(id).get();
		studentsRepository.delete(student);
		return student;
	}
	
	@PutMapping("/studentupdt")
	public StudentsEntity updateStudents(@RequestBody StudentsEntity student) {
		studentsRepository.save(student);
		return student;
	}
}
