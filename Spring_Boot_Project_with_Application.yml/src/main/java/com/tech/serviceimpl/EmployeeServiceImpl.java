package com.tech.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.entity.Employee;
import com.tech.repository.EmployeeRepository;
import com.tech.servicei.EmployeeServiceI;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI {

	@Autowired
	EmployeeRepository empRepository;

	@Override
	public String saveEmployee(Employee emp) {

		empRepository.save(emp);

		return "Employee Id " + emp.getEmp_Id() + " save successfully";
	}

	@Override
	public Optional<Employee> getEmployee(String empId) {

		return empRepository.findById(empId);
	}

	@Override
	public String deleteEmployee(String empId) {

		Optional<Employee> optional = empRepository.findById(empId);

		if (optional.isPresent()) {

			empRepository.deleteById(empId);

			return "Employee Id " + empId + " is delete successfully";
		}

		return null;
	}

	@Override
	public String updateEmployee(Employee emp) {

		Optional<Employee> optional = empRepository.findById(emp.getEmp_Id());

		if (optional.isPresent()) {

			empRepository.save(emp);

			return "Employee Id " + emp.getEmp_Id() + " is updated successfully";
		}

		return null;
	}

}
