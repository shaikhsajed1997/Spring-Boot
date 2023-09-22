package com.tech.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.model.Employee;
import com.tech.repository.EmployeeRepository;
import com.tech.servicei.ServiceI;

@Service
public class ServiceImpl implements ServiceI {

	@Autowired
	EmployeeRepository erp;

	@Override
	public String insertEmployee(Employee e) {

		erp.save(e);
		return "employee data save successfully";
	}

	@Override
	public List<Employee> getEmployees() {
		Iterable<Employee> emps = erp.findAll();

		return (List<Employee>) emps;
	}

	@Override
	public List<Employee> getEmployee(long salary) {
		List<Employee> emps = erp.findBySalary(salary);

		return emps;
	}

	@Override
	public List<Employee> getEmployeeBySalaryLessThan(long salary) {
		List<Employee> emps = erp.findBySalaryLessThanEqual(salary);

		return emps;
	}

	@Override
	public long getEmployeeCount(long salary) {

		long emp = erp.getCountOfEmployee(salary);
		return emp;
	}

	@Override
	public String addEmployees(List<Employee> e) {
		erp.saveAll(e);

		return "All Data Saved Successfully";
	}

}
