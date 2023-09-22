package com.tech.servicei;

import java.util.List;

import com.tech.model.Employee;

public interface ServiceI {
	
	public String insertEmployee(Employee e);
	
	public List<Employee> getEmployees();
	
	public String addEmployees(List<Employee> e);
	
	public List<Employee> getEmployee(long salary);
	
	public List<Employee> getEmployeeBySalaryLessThan(long salary);
	
	public long getEmployeeCount(long salary);

}
