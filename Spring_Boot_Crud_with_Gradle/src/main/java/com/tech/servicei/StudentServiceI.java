package com.tech.servicei;

import java.util.List;
import java.util.Optional;

import com.tech.entity.Student;

public interface StudentServiceI {
	
	//this method for add student record in database
	public String addStudent(Student s);
	
	//get student record from database
	public Optional<Student> getStudent(String sid);
	
	//Delete student record from database
	public String deleteStudent(String sid);
	
	//Update perticular student details in database
	public String updateStudent(Student s);
	
	//Add multiple student record at one time in database
	public String addStudents(List<Student> s);
	
	//get all student record available in database
	public List<Student> getAllStudent();

}
