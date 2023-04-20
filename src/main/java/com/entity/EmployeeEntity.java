package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_info")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String empname;
	private String empemail;
	private String empsalary;
	
	@ManyToOne
	@JoinColumn(name = "Dept_id" , referencedColumnName = "id")
	DepartmentEntity departmentEntity;
	
	public DepartmentEntity getDepartmentEntity() {
		return departmentEntity;
	}
	public void setDepartmentEntity(DepartmentEntity departmentEntity) {
		this.departmentEntity = departmentEntity;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpemail() {
		return empemail;
	}
	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}
	public String getEmpsalary() {
		return empsalary;
	}
	public void setEmpsalary(String empsalary) {
		this.empsalary = empsalary;
	}
}
