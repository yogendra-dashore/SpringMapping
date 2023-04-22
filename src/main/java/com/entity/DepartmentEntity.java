package com.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="department_info")
public class DepartmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Did;
	private String depname;
	
	@JsonIgnore
	@OneToMany(mappedBy = "departmentEntity")
	Set<EmployeeEntity> employeeEntity;
	
	public Set<EmployeeEntity> getEmployeeEntity() {
		return employeeEntity;
	}
	public void setEmployeeEntity(Set<EmployeeEntity> employeeEntity) {
		this.employeeEntity = employeeEntity;
	}
	public Integer getId() {
		return Did;
	}
	public void setId(Integer id) {
		this.Did = id;
	}
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	
}
