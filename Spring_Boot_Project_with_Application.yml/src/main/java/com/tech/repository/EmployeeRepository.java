package com.tech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tech.entity.Employee;

@Repository
public interface EmployeeRepository  extends CrudRepository<Employee, String>{

}
