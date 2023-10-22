package com.tech.servicei;

import java.util.Optional;

import com.tech.entity.Employee;

public interface EmployeeServiceI {
	
	
	public String saveEmployee(Employee emp);
	
	public Optional<Employee> getEmployee(String empId);
	
	public String deleteEmployee(String empId);
	
	public String updateEmployee(Employee emp);

}
