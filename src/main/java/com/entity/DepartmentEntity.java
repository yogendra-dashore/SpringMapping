package com.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="department_info")
public class DepartmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String depname;
	
	@OneToMany(mappedBy = "departmentEntity")
	Set<EmployeeEntity> employeeEntity;
	
	public Set<EmployeeEntity> getEmployeeEntity() {
		return employeeEntity;
	}
	public void setEmployeeEntity(Set<EmployeeEntity> employeeEntity) {
		this.employeeEntity = employeeEntity;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	
}
