package com.tech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.entity.Student;
import com.tech.servicei.StudentServiceI;

@RestController
public class StudentController {

	@Autowired
	StudentServiceI studentService;

	@PostMapping("/student/add")
	public ResponseEntity<Object> addStudent(@RequestBody Student s) {

		String response = studentService.addStudent(s);

		return new ResponseEntity<Object>(response, HttpStatus.CREATED);

	}

	@GetMapping("/student/get/{sid}")
	public ResponseEntity<Object> getStudent(@PathVariable("sid") String sId) {

		Optional<Student> optionalStudent = studentService.getStudent(sId);
		if (optionalStudent.isPresent()) {
			Student student = optionalStudent.get();
			return new ResponseEntity<Object>(student, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("Student Id " + sId + " Not found", HttpStatus.NOT_FOUND);

		}
	}

	@DeleteMapping("/student/delete/{sid}")
	public ResponseEntity<Object> deleteStudent(@PathVariable("sid") String sId) {

		String response = studentService.deleteStudent(sId);
		if (response != null) {
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("Student Id: " + sId + " is Not found ", HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/student/update")
	public ResponseEntity<Object> updateStudent(@RequestBody Student s) {

		String response = studentService.updateStudent(s);
		if (response != null) {
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		} else {
			String message = "Student Id: " + s.getsId() + " is Not Found";
			return new ResponseEntity<Object>(message, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/students/add")
	public ResponseEntity<Object> addStudents(@RequestBody List<Student> s) {

		if (s.isEmpty() == false) {
			String response = studentService.addStudents(s);

			return new ResponseEntity<Object>(response, HttpStatus.CREATED);
		} else {

			return new ResponseEntity<Object>("List of Student is empty", HttpStatus.CREATED);
		}

	}

	@GetMapping("/students/get")
	public ResponseEntity<Object> getStudents() {

		List<Student> allStudent = studentService.getAllStudent();

		return new ResponseEntity<Object>(allStudent, HttpStatus.OK);

	}

}
