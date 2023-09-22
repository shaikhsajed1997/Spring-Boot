package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.model.Employee;
import com.tech.servicei.ServiceI;

@RestController
public class EmployeeController {

	@Autowired
	ServiceI si;

	// to add the data
	@PostMapping("/tech/employee/add/employee")
	public ResponseEntity<Object> insertEmployee(@RequestBody Employee e) {
		try {
			String msg = si.insertEmployee(e);
			return new ResponseEntity<Object>(msg, HttpStatus.CREATED);
		} catch (Exception e2) {
			String s = "You pass the null object Or null employee Id";
			return new ResponseEntity<Object>(s, HttpStatus.OK);
		}

	}

	// to get the data
	@GetMapping("/employee/get")
	public ResponseEntity<Object> getEmployees() {

		List<Employee> employees = si.getEmployees();
		if (employees.isEmpty() == false) {
			return new ResponseEntity<Object>(employees, HttpStatus.OK);
		} else {

			return new ResponseEntity<Object>("Record Not Found ", HttpStatus.OK);
		}
	}

	@PostMapping("/tech/employee/add/employees")
	public ResponseEntity<Object> addEmployees(@RequestBody List<Employee> e) {

		String msg = si.addEmployees(e);

		return new ResponseEntity<Object>(msg, HttpStatus.OK);

	}

	@GetMapping("/API/employee/{salary}")
	public ResponseEntity<Object> getEmployee(@PathVariable long salary) {

		List<Employee> employee = si.getEmployee(salary);
		if (employee.isEmpty() == false) {
			return new ResponseEntity<Object>(employee, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Object>("No record found", HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/API/employee/by/{salary}")
	public ResponseEntity<Object> getEmployeeBySalary(@PathVariable("salary") long salary) {

		List<Employee> employees = si.getEmployeeBySalaryLessThan(salary);

		return new ResponseEntity<Object>(employees, HttpStatus.ACCEPTED);

	}

	@GetMapping("/API/employee/count/{salary}")
	public ResponseEntity<Object> getEmpCount(@PathVariable("salary") long salary) {

		long count = si.getEmployeeCount(salary);

		return new ResponseEntity<Object>("Total Employee= " + count, HttpStatus.ACCEPTED);

	}

}
