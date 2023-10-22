package com.tech.controller;

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

import com.tech.entity.Employee;
import com.tech.servicei.EmployeeServiceI;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeServiceI empService;

	@PostMapping("/employee/add")
	public ResponseEntity<Object> saveEmployee(@RequestBody Employee emp) {

		String msg = empService.saveEmployee(emp);
		return new ResponseEntity<Object>(msg, HttpStatus.CREATED);

	}

	@GetMapping("/employee/get/{empId}")
	public ResponseEntity<Object> getEmployee(@PathVariable("empId") String empId) {

		Optional<Employee> optionalEmp = empService.getEmployee(empId);

		if (optionalEmp.isPresent()) {

			Employee employee = optionalEmp.get();
			return new ResponseEntity<Object>(employee, HttpStatus.OK);
		} else {
			String responseMsg = "Record Not found";
			return new ResponseEntity<Object>(responseMsg, HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/employee/delete/{empId}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("empId") String empId) {

		String response = empService.deleteEmployee(empId);
		if (response != null) {

			return new ResponseEntity<Object>(response, HttpStatus.OK);
		} else {
			String msg = "Record not found";
			return new ResponseEntity<Object>(msg, HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/employee/update")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee emp) {

		String response = empService.updateEmployee(emp);

		if (response != null) {

			return new ResponseEntity<Object>(response, HttpStatus.OK);
		} else {
			String msg = "Employee Id " + emp.getEmp_Id() + " is Not found";
			return new ResponseEntity<Object>(msg, HttpStatus.NOT_FOUND);
		}

	}

}
