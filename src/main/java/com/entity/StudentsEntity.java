package com.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student_info")
public class StudentsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String studentname;
	private String studentlastname;
	private String studentemail;
	private String studentmobno;
	private String studentaddress;
	
	@ManyToMany
	@JoinColumn(name = "cId" , referencedColumnName = "id")
	Set<CourseEntity> courseEntity;
	
	
	
	public Set<CourseEntity> getCourseEntity() {
		return courseEntity;
	}
	public void setCourseEntity(Set<CourseEntity> courseEntity) {
		this.courseEntity = courseEntity;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentlastname() {
		return studentlastname;
	}
	public void setStudentlastname(String studentlastname) {
		this.studentlastname = studentlastname;
	}
	public String getStudentemail() {
		return studentemail;
	}
	public void setStudentemail(String studentemail) {
		this.studentemail = studentemail;
	}
	public String getStudentmobno() {
		return studentmobno;
	}
	public void setStudentmobno(String studentmobno) {
		this.studentmobno = studentmobno;
	}
	public String getStudentaddress() {
		return studentaddress;
	}
	public void setStudentaddress(String studentaddress) {
		this.studentaddress = studentaddress;
	}
	
	
	
}
