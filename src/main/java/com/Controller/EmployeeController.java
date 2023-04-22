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

import com.entity.EmployeeEntity;
import com.repository.DepartmentRepository;
import com.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@PostMapping("/InsertEmp")
	public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employeeEntity) {
		departmentRepository.save(employeeEntity.getDepartmentEntity());
		employeeRepository.save(employeeEntity);
		return employeeEntity;
	}
	
	@GetMapping("/getEmp")
	public List<EmployeeEntity> getAllEmployee() {
		
	return employeeRepository.findAll();
		
	}
	@GetMapping("/getEmpBy/{Id}")
	public EmployeeEntity getEmployeeById(@PathVariable("Id") Integer Id) {
		Optional<EmployeeEntity> emp = employeeRepository.findById(Id);
		if(emp.isEmpty()) {
			return null;
		}
		else {
			return emp.get();
		}
		
	}
	@DeleteMapping("/empdelete/{Id}")
	public EmployeeEntity deleteById(@PathVariable("Id") Integer Id) {
		EmployeeEntity emp = employeeRepository.findById(Id).get();
		employeeRepository.delete(emp);
		return emp;
	}
	
	@PutMapping("/updateByEmp")//null inserted
	public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity emp) {
		employeeRepository.save(emp);
		return emp;
		
	}
}
