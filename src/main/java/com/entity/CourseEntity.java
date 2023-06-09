package com.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="course_info")
public class CourseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	private String coursename;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "courseEntity")
	Set<StudentsEntity> studentsEntity;
	
	
	public Set<StudentsEntity> getStudentsEntity() {
		return studentsEntity;
	}
	public void setStudentsEntity(Set<StudentsEntity> studentsEntity) {
		this.studentsEntity = studentsEntity;
	}
	public Integer getId() {
		return cid;
	}
	public void setId(Integer id) {
		this.cid = id;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	
	
	
}
