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

import com.entity.DepartmentEntity;
import com.repository.DepartmentRepository;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@PostMapping("/InsertDepart")
	public DepartmentEntity addDepartment(@RequestBody DepartmentEntity departmentEntity) {
		departmentRepository.save(departmentEntity);
		return departmentEntity;
	}
	
	@GetMapping("/getDepart")
	public List<DepartmentEntity> getAllDepartment() {
		
	return departmentRepository.findAll();
		
	}
	@GetMapping("/getDepartBy/{Id}")
	public DepartmentEntity getDepartmentById(@PathVariable("Id") Integer Id) {
		Optional<DepartmentEntity> department = departmentRepository.findById(Id);
		if(department.isEmpty()) {
			return null;
		}
		else {
			return department.get();
		}
		
	}
	@DeleteMapping("/departdelete/{Id}")
	public DepartmentEntity deleteById(@PathVariable("Id") Integer Id) {
		DepartmentEntity depart = departmentRepository.findById(Id).get();
		departmentRepository.delete(depart);
		return depart;
	}
	@PutMapping("/updateByDepart")
	public DepartmentEntity updateDepartment(@RequestBody DepartmentEntity depart) {
		departmentRepository.save(depart);
		return depart;
		
	}
	
}
